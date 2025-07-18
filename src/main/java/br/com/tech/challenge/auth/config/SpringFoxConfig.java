package br.com.tech.challenge.auth.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Autorização FastFood")
                        .version("1.0")
                        .description("API de Autenticação fast food")
                        .contact(new Contact()
                                .name("Wesley Junior De Souza")
                                .email("wesjuniorsouza@gmail.com")));
    }
}
