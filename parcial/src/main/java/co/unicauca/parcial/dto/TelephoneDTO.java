package co.unicauca.parcial.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneDTO {
    private Integer telephoneId;
    private String type;
    private String number;
}
