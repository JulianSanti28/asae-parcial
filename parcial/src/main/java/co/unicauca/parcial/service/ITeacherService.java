package co.unicauca.parcial.service;

import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    TeacherDTO save(TeacherDTO teacherDTO);
    List<TeacherDTO> findAll();
    TeacherDTO getById(String teacherID);
    boolean delete(String teacherID);
}
