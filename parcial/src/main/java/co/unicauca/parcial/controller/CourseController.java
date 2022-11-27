package co.unicauca.parcial.controller;

import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO course){
        CourseDTO objCourse = null;
        objCourse = courseService.saveCourse(course);
        return objCourse;
    }

    @GetMapping
    public List<CourseDTO> index(){
        return courseService.findAllCourse();
    }


}
