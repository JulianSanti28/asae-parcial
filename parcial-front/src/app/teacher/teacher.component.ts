import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherDTO } from '../model/TeacherDTO';
import { TeacherService } from '../service/teacher/teacher.service';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit{

  constructor(private teacherService: TeacherService, private router: Router) {

  }
  @Input('teachers') teachers!:TeacherDTO[];
  errors: string[] = [];

  ngOnInit(): void {
    this.teacherService.findAll().subscribe((response) => {
      this.teachers = response;
    })
  }
  editar(teacher: TeacherDTO) {
    console.log("editar: " + teacher)
  }
  eliminar(teacher: TeacherDTO) {
    console.log("eliminar: " +teacher)
  }
}
