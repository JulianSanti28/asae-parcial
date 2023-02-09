import { Component, Input } from '@angular/core';
import { SubjectDTO } from '../model/SubjectDTO';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent {
  @Input('subject') subject !: SubjectDTO;
}
