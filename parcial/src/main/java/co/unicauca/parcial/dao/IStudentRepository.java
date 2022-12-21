package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Integer> {

    List<Student> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String lastName, String email);
    //Mediante la notación @Query consultar si existe un estudiante con un correo electrónico.
    //Utilizar la consulta en la validación correspondiente
    @Query("SELECT e From Student e WHERE e.email = :email")
    Optional<Student> buscarEstudiantePorCorreo(@Param("email") String email);

    //Mediante la notación @Query consultar si existe un estudiante a partir de su número y tipo
    //de identificación. Utilizar la consulta en la validación correspondiente.
    @Query("Select e from Student e where e.identificationNumber = :identificationNumber and e.identificationType = :identificationType")
    Optional<Student> buscarEstudiantePorNumeroYTipoIdentificacion(@Param("identificationNumber") String identificationNumber,
                                                                   @Param("identificationType") String identificationType);

    //Retorna todos los estudiantes en donde su numero identificacion se encuentre en la lista dada
    Set<Student> findAllByIdentificationNumberIn(List<String> identificationNumbers);


}
