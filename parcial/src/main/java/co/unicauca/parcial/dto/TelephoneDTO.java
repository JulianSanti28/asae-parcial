package co.unicauca.parcial.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneDTO {
    private Integer telephoneId;
    private String type;
    @Pattern( regexp = "[8][0-9]{5,20}", message = "{telephone.number}")
    private String number;
}
