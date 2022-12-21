package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ICourseRepository;
import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.exceptionControllers.exceptions.EntityExistsException;
import co.unicauca.parcial.exceptionControllers.exceptions.EntityNotExistsException;
import co.unicauca.parcial.model.Course;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private ISubjectRepository subjectRepository;
    @Autowired
    @Qualifier("subjectMapperBean")
    private ModelMapper subjectMapper;

    @Autowired
    @Qualifier("courseMapperBean")
    private ModelMapper courseMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO course) {

        if(courseRepository.existsById(course.getCourseId()))
            throw new EntityExistsException("Curso con id " + course.getCourseId() + " existe en la BD");

        Course courseEntity = this.courseMapper.map(course,Course.class);

        Course newCourse = this.courseRepository.save(courseEntity);

        return this.courseMapper.map(newCourse,CourseDTO.class);
    }

    @Override
    @Transactional()
    public List<CourseDTO> findAllCourse() {
        Iterable<Course> courses = this.courseRepository.findAll();
        List<CourseDTO> coursesDTO = this.courseMapper.map(courses, new TypeToken<List<CourseDTO>>() {
        }.getType());

        return coursesDTO;
    }

    @Override
    public Optional<CourseDTO> getCourseById(String courseId) {

        if (this.courseRepository.existsById(courseId)){
            return Optional.of(this.courseMapper.map(this.courseRepository.findById(courseId).get(),CourseDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public CourseDTO updateCourse(String courseId, CourseDTO course) {
        return null; //TODO
    }

    @Override
    public boolean deleteCourse(String courseId) {
        if(!courseRepository.existsById(courseId))
            throw new EntityNotExistsException("El curso con el id " + courseId + " no existe en la BD");
        courseRepository.deleteById(courseId);

        return !courseRepository.existsById(courseId);
    }
}
