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
public class DocenteDTO extends PersonaDTO{

    private String universidad;
    private String tipoDocente;
    private float salario;

    Set<AsignaturaDTO> asignaturas;

}
