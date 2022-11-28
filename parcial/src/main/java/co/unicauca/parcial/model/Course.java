package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_subject",nullable = false)
    private Subject subject;

}
