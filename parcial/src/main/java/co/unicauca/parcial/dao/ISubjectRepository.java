package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface ISubjectRepository extends CrudRepository<Subject,Integer> {
}
