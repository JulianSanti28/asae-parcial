package co.unicauca.parcial.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO extends PersonDTO{

    @PastOrPresent(message = "{user.date.past}")
    private Date entryDate;
    @Email(message = "{email.constrain}")
    private String email;

    @Valid
    private AddressDTO address;

    @Valid
    Set<TelephoneDTO> telephones;
}
