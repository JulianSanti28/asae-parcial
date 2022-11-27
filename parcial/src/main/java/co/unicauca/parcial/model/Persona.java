package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;


@MappedSuperclass
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    @Column(length = 50, nullable = false)
    private String noIdentificacion;
    @Column(length = 50, nullable = false)
    private String tipoIdentificacion;
    @Column(length = 50, nullable = false)
    private String nombres;
    @Column(length = 50, nullable = false)
    private String apellidos;
}
