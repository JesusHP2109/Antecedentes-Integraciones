package pe.isil.requisitorias.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})

public class Persona {
    @Id
    @GeneratedValue
    private Integer dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String direccion;
    private String telefono;

}
