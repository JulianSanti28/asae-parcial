package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Curso {
    @Id
    @Column(length = 40)
    private String idCurso;
    private String nombre;
    private int periodo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Asignatura asignatura;
}
