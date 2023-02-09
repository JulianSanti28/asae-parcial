package co.unicauca.parcial.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {
    @Id
    @Column(length = 40)
    private String courseId;
    private String name;
    private int period;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject",nullable = false)
    private Subject subject;

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", period=" + period +
                ", subject=" + subject +
                '}';
    }
}
