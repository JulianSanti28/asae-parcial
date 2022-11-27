package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Integer> {
}
