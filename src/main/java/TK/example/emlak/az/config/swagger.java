package TK.example.emlak.az.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class swagger {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(
                new Info()
                        .title("documented by Tabriz Abilzada")
                        .description("this documentation is about emlak.az")
                        .version("0.0.1")
                        .contact(
                                new Contact()
                                        .url("https://www.linkedin.com/in/tabriz-abilzada-96567227b/")
                                        .name("Tabriz Abilzada")
                                        .email("tabriz.abilzada@gmail.com")

                        )

        );
    }
}
