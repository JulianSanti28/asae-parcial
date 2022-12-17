package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
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

    private String university;

    private String teacherType;
    @Min(value = 0, message = "{teacher.salary.min}")
    private float salary;

//    Set<SubjectDTO> subjects;
}
