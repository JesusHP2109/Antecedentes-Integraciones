package pe.isil.requisitorias;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.isil.requisitorias.model.Persona;
import pe.isil.requisitorias.service.PersonaService;

@Slf4j
@SpringBootApplication
public class RequisitoriasApplication {

    @Autowired
    PersonaService personaService;

    public static void main(String[] args) {
        SpringApplication.run(RequisitoriasApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertProducts(){
        return args -> {

            Persona persona = new Persona();
            persona.setDni(0);
            persona.setNombre("jesus");

            personaService.create(persona);

            log.info("Persona agregado!");

        };
    }
}
