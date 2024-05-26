package TK.example.emlak.az.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize)->{
                    authorize.requestMatchers(HttpMethod.POST,"/emlaks/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.PUT,"/emlaks/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.DELETE,"/emlaks/**").hasRole("ADMIN");
                    authorize.requestMatchers(HttpMethod.GET,"/emlaks/**").hasAnyRole("USER","ADMIN");
                    authorize.requestMatchers(HttpMethod.PATCH,"/emlaks/**").hasAnyRole("USER","ADMIN");
//                    authorize.requestMatchers(HttpMethod.GET,"/emlaks/**").permitAll();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
        return http.build();

    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails hitler = User.builder()
//                .username("hitler")
//                .password(passwordEncoder().encode("1945"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin  = User.builder()
//                .username("Admin")
//                .password(passwordEncoder().encode("admin1945"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(hitler,admin);
//    }

}
