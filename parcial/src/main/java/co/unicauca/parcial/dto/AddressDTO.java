package co.unicauca.parcial.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Integer idStudent;
    @Size(min = 5, max = 25, message = "{address.name.size}")
    private String ubication;
}
