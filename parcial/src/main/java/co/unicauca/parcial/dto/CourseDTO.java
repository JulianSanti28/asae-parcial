package co.unicauca.parcial.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    @NotBlank(message = "{standard.string.constrain}")
    private String courseId;
    @Size(min = 5, max = 25, message = "{course.name.size}")
    private String name;
    @Range(min = 1, max = 2, message = "{course.constrain}")
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
