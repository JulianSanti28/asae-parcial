package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Integer> {

    List<Student> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String lastName, String email);
    //Mediante la notación @Query consultar si existe un estudiante con un correo electrónico.
    //Utilizar la consulta en la validación correspondiente
    @Query("Select e From student where e.email = :email")
    public Student buscarEstudiantePorCorreo(@Param("email") String email);

    //Mediante la notación @Query consultar si existe un estudiante a partir de su número y tipo
    //de identificación. Utilizar la consulta en la validación correspondiente.
    @Query("select e from Student where e.identificationNumber = :identificationNumber and e.identificationType = :identificationType")
    public Student buscarEstudiantePorNumeroYTipoIdentificacion(@Param("identificationNumber") String identificationNumber,
                                                                @Param("identificationType") String identificationType);


}
