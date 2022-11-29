package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;
    private String name;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Course> courses;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "SubjectTeacher", joinColumns = @JoinColumn(name = "subjectId"), inverseJoinColumns = @JoinColumn(name = "teacherId"))
    Set<Teacher> teachers;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", teachers=" + teachers +
                '}';
    }
}
