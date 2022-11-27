package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;
    private String nombre;
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Curso> cursos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AsignaturaDocente", joinColumns = @JoinColumn(name = "asignaturaId"), inverseJoinColumns = @JoinColumn(name = "docenteId"))
    Set<Docente> docentes;
}
