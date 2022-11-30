package co.unicauca.parcial.controller;

import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> findAll(){
        return subjectService.findAllSubject();
    }

    @GetMapping("{subjectId}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable int subjectId){
        Optional<SubjectDTO> subject = this.subjectService.getSubjectById(subjectId);

        if (subject.isPresent()){
            return new ResponseEntity<>(subject.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> save (@RequestBody SubjectDTO newSubject){
        SubjectDTO savedSubject = this.subjectService.saveSubject(newSubject);
        if(savedSubject == null) return ResponseEntity.badRequest().body("No se pudo crear la Asignatura!");
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubject);
    }
}
