import { Component, OnInit } from '@angular/core';
import { CourseService } from '../service/course/course.service';
import { Router } from '@angular/router';
import { CourseDTO } from '../model/CourseDTO';
import swal from 'sweetalert2';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit{

  constructor(private courseService:CourseService,private router: Router) { }

  courses : CourseDTO[] = [];

  ngOnInit(): void {
    this.getAllCourses();
  }

  getAllCourses(){
    this.courseService.getAllCourse().subscribe(response =>{
      this.courses = response as CourseDTO[]
    })
  }

  delete(id:string){
    this.courseService.delete(id).subscribe(response =>{
      console.log("Termino",response)
      swal.fire('Curso Eliminado', `Curso Eliminado con éxito!`,'success');
      this.getAllCourses()
    })
  }



}
