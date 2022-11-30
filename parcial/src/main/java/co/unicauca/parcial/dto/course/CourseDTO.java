package co.unicauca.parcial.dto.course;

import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Subject;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private String courseId;
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
