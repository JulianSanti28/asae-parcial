package co.unicauca.parcial.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Student extends Person {
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date entryDate;
    /*
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, mappedBy = "student")
    private Address address;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    Set<Telephone> telephones;
    */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false, mappedBy = "student")
    private Address address;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
    Set<Telephone> telephones;



    @Builder
    public Student(Integer idPerson, String identificationNumber, String identificationType, String name, String lastName, Date entryDate, Address address, Set<Telephone> telephones) {
        super(idPerson, identificationNumber, identificationType, name, lastName);
        this.entryDate = entryDate;
        this.address = address;
        this.telephones = telephones;
    }
}
