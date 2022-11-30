package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ICourseRepository;
import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.course.CourseDTO;
import co.unicauca.parcial.dto.course.CourseNotFoundException;
import co.unicauca.parcial.model.Course;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;

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
    public Optional<CourseDTO> getCourseById(String courseId) throws CourseNotFoundException {

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
        return false; //TODO
    }
}
