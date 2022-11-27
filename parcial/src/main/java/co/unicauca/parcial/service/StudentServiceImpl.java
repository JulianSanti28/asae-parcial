package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.IStudentRepository;
import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.model.Student;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    @Qualifier("studentMapperBean")
    private ModelMapper studentMapper;

    @Override
    public StudentDTO saveStudent(StudentDTO save) {
        Student toSaveStudent = studentMapper.map(save, Student.class);
        toSaveStudent.getAddress().setStudent(toSaveStudent);
        toSaveStudent.getTelephones().forEach(x->x.setStudent(toSaveStudent));
        toSaveStudent.setEntryDate(new Date());
        Student savedStudent = this.studentRepository.save(toSaveStudent);
        return studentMapper.map(savedStudent, StudentDTO.class);
    }
    @Override
    public List<StudentDTO> findAllStudent() {
        Iterable<Student> students = this.studentRepository.findAll();
        return this.studentMapper.map(students, new TypeToken<List<StudentDTO>>() {
        }.getType());
    }

    @Override
    public StudentDTO getStudentById(Integer code) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(Integer code, StudentDTO update) {
        return null;
    }

    @Override
    public Boolean deleteStudent(Integer code) {
        if(!this.studentRepository.existsById(code)) return false;
        try{
            this.studentRepository.deleteById(code);
            return true;
        }catch (DataIntegrityViolationException e){
            return false;
        }
    }
}
