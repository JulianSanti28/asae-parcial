import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import swal from 'sweetalert2';
import { StudentService } from 'src/app/service/student/student.service';
import { StudentDTO } from 'src/app/model/StudentDTO';
import { AddressDTO } from 'src/app/model/AdressDTO';
import { validateHorizontalPosition } from '@angular/cdk/overlay';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public studentForm !: FormGroup;

  studentModel: StudentDTO = new StudentDTO(
    0, '', '', '', '',
    new Date(), '', new AddressDTO(0,''), []
  );

  constructor(private studentService: StudentService, private frombuilder: FormBuilder, private router: Router) {
    this.studentForm = this.createFormStudent();
  }

  ngOnInit(): void {}

  createFormStudent() {
    return new FormGroup({
      identificationNumber: new FormControl('', [Validators.required]),
      identificationType: new FormControl('', [Validators.required,Validators.minLength(2)]),
      name: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      lastName: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]),
      email: new FormControl('', [
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ]),
      entryDate: new FormControl('', [Validators.required]),
      address: new FormGroup({
        ubication: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(25)])
      }),
      telephones: new FormArray([])
    });
  }

  saveStudent() {
    Object.assign(this.studentModel, this.studentForm.value);
    console.log(this.studentModel)
    this.studentService.saveStudent(this.studentModel).subscribe(response => {
      swal.fire('Estudiante registrado!', `Estudiante ${response.name} ha sido creado!`, 'success');
      this.router.navigate(['/students']);
    },
      err => {
        swal.fire('Cancelado!', `${err.error} !`, 'error');
      }
    );
  }

  removePhone(index: number) {
    const phoneControl = this.studentForm.controls['telephones'] as FormArray;
    phoneControl.removeAt(index);
  }

  addPhone() {
    this.telephones.push(new FormGroup({
      type: new FormControl('', [Validators.required, Validators.minLength(4)]),
      number: new FormControl('', [Validators.required, Validators.pattern('^8[0-9]{5,20}$')])
    }));
  }

  futureDate():boolean{
    const fecha = new Date();
    const fechaSele = new Date(this.entryDate?.value)
    fecha.setHours(0,0,0,0);

    fechaSele.setHours(0,0,0,0)
    fechaSele.setDate(fechaSele.getDate()+1)

    return (fechaSele > fecha);
  }

  get identificationNumber() { return this.studentForm.get('identificationNumber'); }
  get identificationType() { return this.studentForm.get('identificationType'); }
  get name() { return this.studentForm.get('name'); }
  get lastName() { return this.studentForm.get('lastName'); }
  get email() { return this.studentForm.get('email'); }
  get entryDate() { return this.studentForm.get('entryDate'); }
  get address() { return this.studentForm.get('address'); }
  get telephones(): FormArray {
    return this.studentForm.get('telephones') as FormArray;
  }

}
