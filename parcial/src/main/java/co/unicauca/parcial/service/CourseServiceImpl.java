package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ICourseRepository;
import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Course;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//        Course courseEntity = this.courseMapper.map(course,Course.class);
//
//        //Guardar el curso
//        Course newCourse = this.courseRepository.save(courseEntity);
//
//        //Agregar el curso a la lista de cursos de la asigantura
//        Subject subject = subjectRepository.findById(newCourse.getSubject().getSubjectId()).get();
//        subject.getCourses().add(newCourse);
//
//        //Agregar la asignatura
//        newCourse.setSubject(subject);
//
//        CourseDTO courseDTO = this.courseMapper.map(newCourse,CourseDTO.class);
//        return courseDTO;

        Course courseEntity = this.courseMapper.map(course,Course.class);

        Course newCourse = this.courseRepository.save(courseEntity);

        return this.courseMapper.map(newCourse,CourseDTO.class);
    }

    @Override
    @Transactional()
    public List<CourseDTO> findAllCourse() {
        List<CourseDTO> courseDTOS = new ArrayList<>();
        Iterable<Course> courses = this.courseRepository.findAll();

        for(Course c:courses){
            CourseDTO courseDTO = this.courseMapper.map(c,CourseDTO.class);
            courseDTO.setSubject(this.subjectMapper.map(c.getSubject(), SubjectDTO.class));
            courseDTOS.add(courseDTO);
        }

        return courseDTOS;

//        Iterable<Course> courses = this.courseRepository.findAll();
//        List<CourseDTO> coursesDTO = this.courseMapper.map(courses, new TypeToken<List<CourseDTO>>() {
//        }.getType());
//
//        return coursesDTO;
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
