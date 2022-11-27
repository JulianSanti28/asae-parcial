package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ICourseRepository;
import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.model.Course;
import co.unicauca.parcial.model.Subject;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    @Qualifier("courseMapperBean")
    private ModelMapper courseMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO course) {

        Course courseEntity = this.courseMapper.map(course,Course.class);
        System.out.println(courseEntity.getName());

        //courseEntity.getSubject().getCourses().add(courseEntity);
        Course objCourse = this.courseRepository.save(courseEntity);
        System.out.println(objCourse.getName());

        Optional<Subject> optionalSubject =subjectRepository.findById(objCourse.getSubject().getSubjectId());
        Subject subject = optionalSubject.get();

        //agregar el curso
        subject.getCourses().add(objCourse);
        //agregar la asignatura
        objCourse.setSubject(subject);
        System.out.println(objCourse.getSubject().getCourses());

        CourseDTO courseDTO = this.courseMapper.map(objCourse,CourseDTO.class);

        return courseDTO;
    }

    @Override
    @Transactional()
    public List<CourseDTO> findAllCourse() {
        Iterable<Course> courses = this.courseRepository.findAll();

        return this.courseMapper.map(courses,new TypeToken<List<CourseDTO>>(){}.getType());
    }

    @Override
    public CourseDTO getCourseById(String courseId) {
        return null; //TODO
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
