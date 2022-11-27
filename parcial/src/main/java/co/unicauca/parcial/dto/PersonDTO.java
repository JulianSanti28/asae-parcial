package co.unicauca.parcial.dto;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Integer idPerson;
    private String identificationNumber;
    private String identificationType;
    private String name;
    private String lastName;
}
