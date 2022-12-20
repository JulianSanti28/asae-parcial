package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {

    //Mediante la notación @Query consultar si existe un docente a partir de su número y
    //tipo de  identificación. Utilizar la consulta en la validación correspondiente.

    @Query("SELECT t FROM teacher u WHERE t.identificationType = :identificationType and t.identificationNumber = :identificationNumber")
    public Teacher buscarDocentePorTipoDeIdentificacionYnumeroDeIdentificacion(
            @Param("identificationType") String identificationType,
            @Param("identificationNumber") String identificationNumber);
}
