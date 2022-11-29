package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {
}
