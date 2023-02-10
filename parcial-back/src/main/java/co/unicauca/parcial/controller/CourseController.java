package co.unicauca.parcial.controller;

import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.service.ICourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@Validated
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDTO create(@Valid @RequestBody CourseDTO course){
        CourseDTO objCourse = null;
        objCourse = courseService.saveCourse(course);
        return objCourse;
    }

    @GetMapping
    public List<CourseDTO> findAll(){
        return courseService.findAllCourse();
    }

    @GetMapping("{idCurso}")
    public ResponseEntity<CourseDTO> findById( @PathVariable String idCurso) {
        Optional<CourseDTO> course = courseService.getCourseById(idCurso);

        if (course.isPresent()){
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{idCurso}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String idCurso){
        return new ResponseEntity<>(courseService.deleteCourse(idCurso),HttpStatus.OK);
    }


}
