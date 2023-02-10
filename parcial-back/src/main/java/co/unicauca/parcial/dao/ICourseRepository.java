package co.unicauca.parcial.dao;

import co.unicauca.parcial.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course,String> {
}
