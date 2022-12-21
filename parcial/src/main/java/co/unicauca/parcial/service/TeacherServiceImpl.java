package co.unicauca.parcial.service;

import co.unicauca.parcial.dao.IStudentRepository;
import co.unicauca.parcial.dao.ITeacherRepository;
import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.exceptionControllers.exceptions.EntityExistsException;
import co.unicauca.parcial.model.Course;
import co.unicauca.parcial.model.Student;
import co.unicauca.parcial.model.Teacher;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService{

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    @Qualifier("teacherMapperBean")
    private ModelMapper teacherMapper;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {

        if(teacherRepository.buscarDocentePorTipoDeIdentificacionYnumeroDeIdentificacion(teacherDTO.getIdentificationType(), teacherDTO.getIdentificationNumber()).isPresent())
            throw new EntityExistsException("Docente con id " + teacherDTO.getIdentificationNumber() + " existe en la BD");


        Teacher teacherEntity = this.teacherMapper.map(teacherDTO,Teacher.class);

        Teacher newTeacher = this.teacherRepository.save(teacherEntity);

        return this.teacherMapper.map(newTeacher, TeacherDTO.class);

    }

    @Override
    public List<TeacherDTO> findAll() {
        Iterable<Teacher> students = this.teacherRepository.findAll();
        return this.teacherMapper.map(students, new TypeToken<List<TeacherDTO>>() {
        }.getType());
    }

    @Override
    public TeacherDTO getById(String teacherID) {
        return null; //TODO
    }

    @Override
    public boolean delete(String teacherID) {
        return false; //TODO
    }
}
