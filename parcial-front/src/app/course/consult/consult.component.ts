import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CourseDTO } from 'src/app/model/CourseDTO';
import { CourseService } from 'src/app/service/course/course.service';

@Component({
  selector: 'app-consult',
  templateUrl: './consult.component.html',
  styleUrls: ['./consult.component.css']
})
export class ConsultComponent implements OnInit{

  course !: CourseDTO;


  constructor(private courseService:CourseService, private router:Router){

  }
  ngOnInit(): void {
    this.courseService.getCourseByID("1A").subscribe( response =>{
      this.course = response as CourseDTO
    })

  }

}
