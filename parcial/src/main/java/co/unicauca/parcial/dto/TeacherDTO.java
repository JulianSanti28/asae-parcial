package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    private float salary;

//    Set<SubjectDTO> subjects;
}
