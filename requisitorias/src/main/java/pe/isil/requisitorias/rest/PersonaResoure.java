package pe.isil.requisitorias.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.requisitorias.model.Persona;
import pe.isil.requisitorias.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaResoure {
    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity getAll() {

        List<Persona> personas = personaService.getAllPersona();

        if (personas == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/personas")
    public ResponseEntity create(@RequestBody Persona persona) {

        personaService.create(persona);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @PutMapping("/personas/{dni}")
    public ResponseEntity<Persona> update(@PathVariable("dni") Integer dni,
                                           @RequestBody Persona persona) {

        Persona personaActual = personaService.findById(dni);

        if (personaActual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personaActual.setNombre(persona.getNombre());

        personaService.update(personaActual);

        return new ResponseEntity<>(personaActual, HttpStatus.OK);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity delete(@PathVariable("dni") Integer dni) {

        Persona personaActual = personaService.findById(dni);

        if (personaActual == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        personaService.delete(dni);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/personas/{dni}")
    public ResponseEntity<Persona> get(@PathVariable("dni") Integer dni) {

        Persona personaActual = personaService.findById(dni);

        if (personaActual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personaActual, HttpStatus.OK);
    }
    ;


}
