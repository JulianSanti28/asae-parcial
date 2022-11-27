package co.unicauca.parcial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO {

    private Integer idAsignatura;
    private String nombre;

    Set<CursoDTO> cursos;
    Set<DocenteDTO> docentes;
}
