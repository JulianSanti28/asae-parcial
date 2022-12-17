package co.unicauca.parcial.dto;

import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Subject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private String courseId;
    @Size(min = 5, max = 25, message = "{course.name.size}")
    private String name;
    private int period;

    private SubjectDTO subject;

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", period=" + period +
                ", subject=" + subject +
                '}';
    }
}
