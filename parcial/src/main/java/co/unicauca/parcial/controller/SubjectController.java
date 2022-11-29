package co.unicauca.parcial.controller;

import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.model.Course;
import co.unicauca.parcial.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> findAll(){
        return subjectService.findAllSubject();
    }

    @PostMapping
    public SubjectDTO save (@RequestBody SubjectDTO newSubject, @RequestBody CourseDTO course, @RequestBody TeacherDTO teacher){
        System.out.println(newSubject);
        System.out.println(course);
        System.out.println(teacher);
        return this.subjectService.saveSubject(newSubject);
    }
}
