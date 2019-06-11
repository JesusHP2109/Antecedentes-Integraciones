package pe.isil.requisitoriaconsuming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RequisitoriaConsumingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequisitoriaConsumingApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner runner(RestTemplate restTemplate) {
        return args -> {

            List personas = restTemplate.getForObject(
                    "http://localhost:8080/api/personas", List.class);

            System.out.println("personas = [" + personas + "]");
        };
    }


}
