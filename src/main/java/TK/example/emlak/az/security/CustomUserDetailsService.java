package TK.example.emlak.az.security;

import TK.example.emlak.az.entity.User;
import TK.example.emlak.az.repository.UserRepository;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String fullnameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByFullNameOrEmail(fullnameOrEmail,fullnameOrEmail).orElseThrow(()-> new UsernameNotFoundException("User not exists by fullname or email"));

        Set<GrantedAuthority> authoritySet = user.getRoles().stream().map(
                (role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());


        return new org.springframework.security.core.userdetails.User(
                fullnameOrEmail,
                user.getPassword(),
                authoritySet
        );
    }
}
