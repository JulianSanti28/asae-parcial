import { Component, Input } from '@angular/core';
import { CourseDTO } from 'src/app/model/CourseDTO';

@Component({
  selector: 'app-course-view',
  templateUrl: './course-view.component.html',
  styleUrls: ['./course-view.component.css']
})
export class CourseViewComponent {

  @Input('course') course !: CourseDTO;

}
