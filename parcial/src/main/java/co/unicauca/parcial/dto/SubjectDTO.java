package co.unicauca.parcial.dto;

import co.unicauca.parcial.model.Course;
import co.unicauca.parcial.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private Integer subjectId;

    private String name;

//    Set<CourseDTO> courses;

    Set<TeacherDTO> teachers;

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                '}';
    }
}
