package co.unicauca.parcial.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private Integer subjectId;
    @Size(min = 5, max = 25, message = "{subject.name.size}")
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
