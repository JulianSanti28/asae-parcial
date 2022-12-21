package co.unicauca.parcial.service;

import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.model.Student;

import java.util.List;

public interface IStudentService {

    StudentDTO saveStudent(StudentDTO save);
    List<StudentDTO> findAllStudent();
    StudentDTO getStudentById(Integer code);
    StudentDTO updateStudent(Integer code, StudentDTO update);
    Boolean deleteStudent(Integer code);
    List<StudentDTO> findByNameOrLastNameOrEmail(String name, String lastName, String email);


}
