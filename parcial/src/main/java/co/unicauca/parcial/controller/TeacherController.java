package co.unicauca.parcial.controller;


import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> findAll(){
        return teacherService.findAll();
    }

    @PostMapping
    public TeacherDTO create(@RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacher = null;
        teacher = teacherService.save(teacherDTO);
        return teacher;
    }

}
