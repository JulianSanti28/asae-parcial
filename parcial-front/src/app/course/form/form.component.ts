import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CourseDTO } from 'src/app/model/CourseDTO';
import { SubjectDTO } from 'src/app/model/SubjectDTO';
import { CourseService } from 'src/app/service/course/course.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{
  courseForm !: FormGroup;
  course :CourseDTO = new CourseDTO();
  errores !: string [];

  constructor(private courseService:CourseService, private router:Router){
    this.courseForm = this.createFormCourse();
  }
  ngOnInit(): void {


  }

  createFormCourse(){
    return new FormGroup({
      courseId : new FormControl('',[Validators.required]),
      name : new FormControl('',[Validators.required,Validators.minLength(5), Validators.maxLength(25)]),
      period : new FormControl('',[Validators.required, Validators.minLength(1), Validators.maxLength(2)]),
      subjectID : new FormControl('',[Validators.required])
    });
  }

  saveCourse(){
    this.courseSave();
    console.log(this.course);
    this.courseService.save(this.course).subscribe(
      response =>{
        this.router.navigate(['/course']),
        swal.fire('Nuevo Curso', `Curso ${response.name} creado con éxito!`,'success');
      },
      err => {
       console.log(err.error)
       this.errores = err.error as string [];
       console.error('codigo del error desde el backend: '+ err.status);
      }
    );
  }

  private courseSave(){
    this.course.courseId = this.id?.value;
    this.course.name = this.name?.value;
    this.course.period = this.period?.value;
    this.course.subject = new SubjectDTO();
    this.course.subject.subjectId = +this.subjectID?.value;
  }

  get id(){ return this.courseForm.get('courseId')}
  get name(){ return this.courseForm.get('name')}
  get period(){ return this.courseForm.get('period')}
  get subjectID(){return this.courseForm.get('subjectID')}

}
