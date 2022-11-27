package co.unicauca.parcial.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class PersonaDTO {
    private Integer idPersona;
    private String noIdentificacion;
    private String tipoIdentificacion;
    private String nombres;
    private String apellidos;
}
