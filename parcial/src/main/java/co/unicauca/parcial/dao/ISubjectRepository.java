package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISubjectRepository extends CrudRepository<Subject,Integer> {

    //Obtiene todas las materias que coincidan con el nombre dado.
    List<Subject> findAllByNameContainingIgnoreCaseOrderByNameAsc(String name);
}
