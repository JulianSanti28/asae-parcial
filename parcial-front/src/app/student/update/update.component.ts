import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import swal from 'sweetalert2';
import { Router } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student/student.service';



@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  public studentForm !: FormGroup;
  studentModel = new Student;
  public errores: string[] = [];

  constructor(private studentService: StudentService, private router: Router) {
    this.studentForm = this.createFormStudent();
  }

  ngOnInit(): void {
    this.studentService.findStudentById(+localStorage.getItem('studentId')!)
      .subscribe(response => {
        if (response.body) {
          this.studentModel = response.body;
          this.studentForm.controls['identification'].setValue(response.body.identification);
          this.studentForm.controls['name'].setValue(response.body.name);
          this.studentForm.controls['lastName'].setValue(response.body.lastName);
          this.studentForm.controls['email'].setValue(response.body.email);
        }
      }
    )
  }

  createFormStudent() {
    return new FormGroup({
      code: new FormControl('', [Validators.required]),
      identification: new FormControl('', [Validators.required]),
      //Validators.required, Validators.minLength(3), Validators.maxLength(10)
      name: new FormControl('', []),
      lastName: new FormControl('', []),
      email: new FormControl('', [
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ])
    });
  }

  saveStudent() {
    this.studentModel = Object.assign(this.studentModel, this.studentForm.value);
    this.studentService.updateStudent(this.studentModel).subscribe(response => {
      this.router.navigate(['/students']);
      swal.fire('Student Updated!', `Student ${response.name} successfully updated!`, 'success');
    },
     err => {
        this.errores = err.error.errors as string[];
      }
    );
  }
  get code() { return this.studentForm.get('code'); }
  get identification() { return this.studentForm.get('identification'); }
  get name() { return this.studentForm.get('name'); }
  get lastName() { return this.studentForm.get('lastName'); }
  get email() { return this.studentForm.get('email'); }

}
