package pe.isil.requisitorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.requisitorias.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
