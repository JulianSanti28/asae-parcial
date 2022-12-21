package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO extends PersonDTO {
    @NotBlank(message = "{standard.string.constrain}")
    private String university;
    @NotBlank(message = "{standard.string.constrain}")
    private String teacherType;
    @Positive(message = "{teacher.salary.min}")
    private float salary;

//    Set<SubjectDTO> subjects;
}
