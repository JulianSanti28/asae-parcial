package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Course;
import co.unicauca.parcial.model.Subject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectServiceImpl implements ISubjectService{
    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    @Qualifier("subjectMapperBean")
    private ModelMapper subjectMapper;

    @Autowired
    @Qualifier("courseMapperBean")
    private ModelMapper courseMapper;

    @Override
    public SubjectDTO saveSubject(SubjectDTO subject) {
//        Subject newSubject = this.subjectMapper.map(subject, Subject.class);
//
//        Set<Course> courses = new HashSet<>();
//        for (CourseDTO c: subject.getCourses()){
//            Course course = this.courseMapper.map(c, Course.class);
//            course.setSubject(newSubject);
//            courses.add(course);
//        }
//
//        newSubject.setCourses(courses);
//
//
//        return this.subjectMapper.map(this.subjectRepository.save(newSubject), SubjectDTO.class);
        return null;
    }

    @Override
    public List<SubjectDTO> findAllSubject() {

        Iterable<Subject> subjects = this.subjectRepository.findAll();
        List<SubjectDTO> subjectsDTO = this.subjectMapper.map(subjects, new TypeToken<List<SubjectDTO>>() {
        }.getType());

        return subjectsDTO;
    }

    @Override
    public Optional<SubjectDTO> getSubjectById(int subjectId) {
        if (this.subjectRepository.existsById(subjectId)){
            return Optional.of(this.subjectMapper.map(this.subjectRepository.findById(subjectId).get(), SubjectDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public SubjectDTO updateSubject(int subjectId, SubjectDTO subject) {
        return null; //Todo
    }

    @Override
    public boolean deleteSubject(int subjectId) {
        return false; //Todo
    }
}
