package co.unicauca.parcial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CursoDTO {

    private String idCurso;
    private String nombre;
    private int periodo;

    private AsignaturaDTO asignatura;

}
