import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TeacherDTO } from 'src/app/model/TeacherDTO';
import { TeacherService } from 'src/app/service/teacher/teacher.service';

@Component({
  selector: 'app-list-teacher',
  templateUrl: './list-teacher.component.html',
  styleUrls: ['./list-teacher.component.css']
})
export class ListTeacherComponent implements OnInit{
  constructor(private teacherService: TeacherService, private router: Router) {

  }
  @Input('teachers') teachers!:TeacherDTO[];
  errors: string[] = [];

  ngOnInit(): void {
    this.teacherService.findAll().subscribe((response) => {
      this.teachers = response;
    })
  }
}
