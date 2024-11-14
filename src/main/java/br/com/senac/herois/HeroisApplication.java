package br.com.senac.herois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HeroisApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroisApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500") // ajuste a origem conforme necessário
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // métodos HTTP permitidos
                        .allowedHeaders("*") // cabeçalhos permitidos
                        .allowCredentials(true); // permite credenciais (opcional)
            }
        };
    }
}