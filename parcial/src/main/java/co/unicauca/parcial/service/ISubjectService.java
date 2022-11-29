package co.unicauca.parcial.service;

import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISubjectService {
    SubjectDTO saveSubject(SubjectDTO subject);
    List<SubjectDTO> findAllSubject();
    SubjectDTO getSubjectById(String subjectId);
    SubjectDTO updateSubject(String subjectId, SubjectDTO subject);
    boolean deleteSubject(String subjectId);
}
