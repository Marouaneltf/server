package socialMediaApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v2/api-docs")
                .allowedOrigins("http://localhost:9090"); // replace with your Swagger UI URL
        registry.addMapping("/swagger-ui/**")
                .allowedOrigins("http://localhost:9090");
    }
}
