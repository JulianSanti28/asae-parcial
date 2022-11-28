package co.unicauca.parcial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Teacher extends Person {
    @Column(length = 50, nullable = false)
    private String university;
    @Column(length = 50, nullable = false)
    private String teacherType;
    @Column(length = 50, nullable = false)
    private float salary;
    //@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
    //Set<Subject> subjects;

}
