package co.unicauca.parcial.controller;


import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.service.ITeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Validated
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @GetMapping
    public List<TeacherDTO> findAll(){
        return teacherService.findAll();
    }

    @PostMapping
    public TeacherDTO create(@Valid @RequestBody TeacherDTO teacherDTO){
        TeacherDTO teacher = null;
        teacher = teacherService.save(teacherDTO);
        return teacher;
    }

}
