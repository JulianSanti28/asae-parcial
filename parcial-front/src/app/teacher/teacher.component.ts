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

  constructor() {}
  @Input('teachers') teachers!:TeacherDTO[];
  errors: string[] = [];

  ngOnInit(): void {}
}
