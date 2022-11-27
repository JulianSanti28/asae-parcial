package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Address;
import co.unicauca.parcial.model.Telephone;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer idPerson;
    private String identificationNumber;
    private String identificationType;
    private String name;
    private String lastName;
    @PastOrPresent(message = "Entry date cannot be future")
    private Date entryDate;
    private AddressDTO address;
    Set<TelephoneDTO> telephones;
}