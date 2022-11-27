package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefono;
    private String tipo;
    private String numero;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudianteId")
    private Estudiante estudiante;
}
