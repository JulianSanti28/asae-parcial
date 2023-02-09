package co.unicauca.parcial.controller;


import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.service.IStudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Validated
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentDTO request){
        StudentDTO savedStudent = this.studentService.saveStudent(request);
        if(savedStudent == null) return ResponseEntity.badRequest().body("No se pudo crear el estudiante!");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAllStudent(){
        List<StudentDTO> students = this.studentService.findAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestParam(name = "id") Integer id){
        Boolean isDeleted = this.studentService.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        if (!isDeleted) {
            response.put("message", "Error al eliminar el estudiante");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("message", "Estudiante eliminado exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@Min(0) @PathVariable Integer id){
        ResponseEntity<?> responseEntity = null;
        StudentDTO studentDTO = this.studentService.getStudentById(id);
        if( studentDTO == null) {
            responseEntity = new ResponseEntity("No se encontro el usuario", HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity(studentDTO, HttpStatus.OK);
        }

        return responseEntity;
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody StudentDTO body){
        ResponseEntity<?> responseEntity = null;
        StudentDTO studentDTO = this.studentService.updateStudent(body.getIdPerson(), body);

        if( studentDTO == null) {
            responseEntity = new ResponseEntity("No se encontro el usuario a actualizar", HttpStatus.NOT_FOUND);
        }else {
            responseEntity = new ResponseEntity(studentDTO, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/findLike")
    public ResponseEntity<?> findStudentsLike(@RequestParam String name, @RequestParam String lastName, @RequestParam String email){
        List<StudentDTO> studentDTOS = this.studentService.findByNameOrLastNameOrEmail(name, lastName, email);

        if (studentDTOS.isEmpty()) return new ResponseEntity(studentDTOS, HttpStatus.NO_CONTENT);

        return new ResponseEntity(studentDTOS, HttpStatus.OK);
    }
    @GetMapping("/findWithIn")
    public ResponseEntity<?> findStudentWithInDnaList(@RequestParam(name ="identificationNumber") List<String> identificationNumber){
        List<StudentDTO> students = this.studentService.findAllStudentWithinDnaList(identificationNumber);
        if(students.isEmpty()) return new ResponseEntity(students, HttpStatus.NO_CONTENT);
        return new ResponseEntity(students,HttpStatus.OK);
    }

}
