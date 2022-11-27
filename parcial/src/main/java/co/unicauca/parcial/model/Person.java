package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;


@MappedSuperclass
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerson;
    @Column(length = 50, nullable = false)
    private String identificationNumber;
    @Column(length = 50, nullable = false)
    private String identificationType;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String lastName;
}
