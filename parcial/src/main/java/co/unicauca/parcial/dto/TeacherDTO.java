package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends PersonDTO {

    private String university;
    private String teacherType;
    private float salary;

    Set<SubjectDTO> subjects;
}
