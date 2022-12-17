package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.IStudentRepository;
import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.model.Address;
import co.unicauca.parcial.model.Student;
import co.unicauca.parcial.model.Telephone;
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
    @Qualifier("studentModelMapper")
    private ModelMapper studentModelMapper;

    @Autowired
    @Qualifier("modelMapperStudentToStudentDto")
    private ModelMapper modelMapperStudentToStudentDto;

    @Override
    public StudentDTO saveStudent(StudentDTO save) {
        Student toSaveStudent = studentModelMapper.map(save, Student.class);
        toSaveStudent.getAddress().setStudent(toSaveStudent);
        toSaveStudent.getTelephones().forEach(x->x.setStudent(toSaveStudent));
        Student savedStudent = this.studentRepository.save(toSaveStudent);
        return studentModelMapper.map(savedStudent, StudentDTO.class);
    }
    @Override
    public List<StudentDTO> findAllStudent() {
        Iterable<Student> students = this.studentRepository.findAll();
        return this.studentModelMapper.map(students, new TypeToken<List<StudentDTO>>() {
        }.getType());
    }

    @Override
    public StudentDTO getStudentById(Integer code) {
        StudentDTO studentDTO = null;
        //Implementation relations LAZY

        if(studentRepository.existsById(code)){
            studentDTO = studentModelMapper.map(studentRepository.findById(code).get(),StudentDTO.class);
        }


        /*
        //Implementation relations EAGER
        if(studentRepository.existsById(code)){
            studentDTO = modelMapperStudentToStudentDto.map(studentRepository.findById(code).get(),StudentDTO.class);
        }
        */

        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(Integer code, StudentDTO update) {
        StudentDTO studentDTO = null;
        if(this.studentRepository.existsById(code)){
            Student student = this.studentRepository.findById(code).get();
            student = studentModelMapper.map(update,Student.class);
            student.getAddress().setIdStudent(code);

            for (Telephone t:student.getTelephones()){
                t.setStudent(student);
            }


            studentDTO = studentModelMapper.map(this.studentRepository.save(student),StudentDTO.class);
        }
        return studentDTO;
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
