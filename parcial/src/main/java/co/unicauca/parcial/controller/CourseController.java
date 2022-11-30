package co.unicauca.parcial.controller;

import co.unicauca.parcial.dto.course.CourseDTO;
import co.unicauca.parcial.dto.course.CourseNotFoundException;
import co.unicauca.parcial.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<CourseDTO> findAll(){
        return courseService.findAllCourse();
    }

    @GetMapping("{idCurso}")
    public ResponseEntity<CourseDTO> findById(@PathVariable String idCurso) throws CourseNotFoundException {
        Optional<CourseDTO> course = courseService.getCourseById(idCurso);

        if (course.isPresent()){
            return new ResponseEntity<>(course.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
