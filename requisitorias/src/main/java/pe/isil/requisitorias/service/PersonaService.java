package pe.isil.requisitorias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.requisitorias.model.Persona;
import pe.isil.requisitorias.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;


    List<Persona> persona = new ArrayList<>(
    );


    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    public Persona findById(Integer dni){
        return personaRepository.getOne(dni);
    }

    public Persona findByDni(Integer dni) {
        for (Persona persona : persona) {
            if (persona.getDni().equals(dni)) {
                return persona;
            }
        }
        return null;
    }

    public void create(Persona persona) {
        personaRepository.save(persona);
    }

    public void update(Persona persona) {
        personaRepository.save(persona);
    }

    public void delete(Integer dni) {
        Persona persona = personaRepository.getOne(dni);
        personaRepository.delete(persona);
    }

}
