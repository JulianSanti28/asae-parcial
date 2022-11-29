package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Subject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService{
    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    @Qualifier("subjectMapperBean")
    private ModelMapper subjectMapper;

    @Override
    public SubjectDTO saveSubject(SubjectDTO subject) {

        Subject newSubject = this.subjectRepository.save(this.subjectMapper.map(subject, Subject.class));

        newSubject.getCourses().forEach(x -> {
            x.setSubject(newSubject);
        });

        //todo crear techer
        //todo crear course

        return this.subjectMapper.map(newSubject, SubjectDTO.class);
    }

    @Override
    public List<SubjectDTO> findAllSubject() {

        Iterable<Subject> subjects = this.subjectRepository.findAll();
        List<SubjectDTO> subjectsDTO = this.subjectMapper.map(subjects, new TypeToken<List<SubjectDTO>>() {
        }.getType());

        return subjectsDTO;
    }

    @Override
    public SubjectDTO getSubjectById(String subjectId) {
        return null;
    }

    @Override
    public SubjectDTO updateSubject(String subjectId, SubjectDTO subject) {
        return null; //Todo
    }

    @Override
    public boolean deleteSubject(String subjectId) {
        return false; //Todo
    }
}
