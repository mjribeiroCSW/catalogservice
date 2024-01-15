package csw.catalogservice.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenAPIConfiguration {

    private static final String SECURITY_SCHEME_NAME = "Bearer oAuth Token";

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String TOKENURL;

    @Bean
    public OpenAPI myOpenAPI() {

        var mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        var info = new Info()
                .title("Catalog Service API")
                .version("1.0")
                .description("This API exposes endpoints to manage books.")
                .license(mitLicense);

        var oauthConfig = new Components()
                .addSecuritySchemes("spring_oauth", new SecurityScheme()
                        .type(SecurityScheme.Type.OAUTH2)
                        .description("Oauth2 flow")
                        .flows(new OAuthFlows()
                                .clientCredentials(new OAuthFlow()
                                        .tokenUrl("http://localhost:3000/realms/master/protocol/openid-connect/token")
                                        .scopes(new Scopes()
                                            .addString("read_books", "for read operations")
                                            .addString("write_books", "for write operations")
                                        ))));

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(oauthConfig)
                .security(Arrays.asList(new SecurityRequirement().addList("spring_oauth")))
                .info(info);
    }
    /*
    @Bean
    public OpenAPI defineOpenApi() {
        var server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        var myContact = new Contact();
        myContact.setName("Mateus J Ribeiro");
        myContact.setEmail("email@gmail.com");

        var information = new Info()
                .title("Catalog Service API")
                .version("1.0")
                .description("This API exposes endpoints to manage books.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    } */
}