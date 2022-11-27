package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Direccion {
    @Id
    private Integer idEstudiante;
    private String numeroTelefono;
    private String tipoTelefono;
    @OneToOne
    @MapsId
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
}
