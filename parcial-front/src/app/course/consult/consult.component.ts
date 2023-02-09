import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseDTO } from 'src/app/model/CourseDTO';
import { SubjectDTO } from 'src/app/model/SubjectDTO';
import { TeacherDTO } from 'src/app/model/TeacherDTO';
import { CourseService } from 'src/app/service/course/course.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-consult',
  templateUrl: './consult.component.html',
  styleUrls: ['./consult.component.css']
})
export class ConsultComponent implements OnInit{
  courseId !: string;
  course !: CourseDTO;
  subject !: SubjectDTO;
  teachers : TeacherDTO[] = [];

  constructor(private courseService:CourseService, private router:Router,private routeParam: ActivatedRoute){
    this.courseId = String(this.routeParam.snapshot.paramMap.get('courseId'))
  }
  ngOnInit(): void {
    this.courseService.getCourseByID(this.courseId).subscribe(
      response =>{
      this.course = response as CourseDTO;
      this.teachers = this.course.subject.teachers
      this.subject = this.course.subject
      },
      err =>{
        this.router.navigate(['/course']),
        console.log(err.error)
        console.log(this.course)
        swal.fire('Curso No Existe', `El curso no se encontro`,'error');
      }
      )
  }

}
