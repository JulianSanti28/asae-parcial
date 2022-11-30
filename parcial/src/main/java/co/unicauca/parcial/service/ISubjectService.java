package co.unicauca.parcial.service;

import co.unicauca.parcial.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    SubjectDTO saveSubject(SubjectDTO subject);
    List<SubjectDTO> findAllSubject();
    Optional<SubjectDTO> getSubjectById(int subjectId);
    SubjectDTO updateSubject(int subjectId, SubjectDTO subject);
    boolean deleteSubject(int subjectId);
}
