import { Component, Input, OnInit } from '@angular/core';
import { TeacherDTO } from '../model/TeacherDTO';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit{

  @Input('teachers') teachers!:TeacherDTO[];

  ngOnInit(): void {
    console.log(this.teachers)
  }





}
