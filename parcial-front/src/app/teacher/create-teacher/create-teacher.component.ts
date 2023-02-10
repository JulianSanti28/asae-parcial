import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TeacherDTO } from 'src/app/model/TeacherDTO';
import { TeacherService } from 'src/app/service/teacher/teacher.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrls: ['./create-teacher.component.css']
})
export class CreateTeacherComponent implements OnInit {
  teacherForm !: FormGroup;
  teacherModel: TeacherDTO = new TeacherDTO(0,'','','','','','',0)
  errores !: string [];

  constructor(private teacherService: TeacherService, private frombuilder: FormBuilder, private router: Router) {
    this.teacherForm = this.createFormTeacher();
  }

  ngOnInit(): void {}

  createFormTeacher() {
    return new FormGroup({
      identificationNumber: new FormControl('', [Validators.required]),
      identificationType: new FormControl('', [Validators.required,Validators.minLength(2)]),
      name: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      university: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]),
      salary: new FormControl('', [Validators.required,Validators.min(1)]),
      teacherType: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
    });
  }
  saveTeacher() {
    Object.assign(this.teacherModel,this.teacherForm.value);
    this.teacherService.saveTeacher(this.teacherModel).subscribe(response => {
        Swal.fire('Profesor registrado!', `Estudiante ${response.name} ha sido creado!`, 'success');
        this.router.navigate(['/teachers']);
      },
      err => {
        this.errores = err.error as string [];
        console.log("aqui",this.errores)
        console.error('codigo del error desde el backend: '+ err.status);
        Swal.fire('Profesor NO registrado!', `Verifique los campos e intente nuevamente `, 'error');
      }
    );
  }
  get identificationNumber() { return this.teacherForm.get('identificationNumber'); }
  get identificationType() { return this.teacherForm.get('identificationType'); }
  get name() { return this.teacherForm.get('name'); }
  get lastName() { return this.teacherForm.get('lastName'); }
  get teacherType() {return this.teacherForm.get('teacherType')}
  get university() {return this.teacherForm.get('university')}
  get salary() { return this.teacherForm.get('salary'); }
}
