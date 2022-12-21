package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    private Integer idStudent;
    private String ubication;
    @OneToOne
    @MapsId
    @JoinColumn(name = "studentId")
    private Student student;
}
