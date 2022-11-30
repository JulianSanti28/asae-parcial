package co.unicauca.parcial.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    Set<CourseDTO> courses;
    Set<TeacherDTO> teachers;
    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                '}';
    }
}
