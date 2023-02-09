import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';
import swal from 'sweetalert2';
import { Router } from '@angular/router';
import { AddressDTO } from 'src/app/model/AdressDTO';
import { StudentService } from 'src/app/service/student/student.service';
import { StudentDTO } from 'src/app/model/StudentDTO';
import { TelephoneDTO } from 'src/app/model/TelephoneDTO';



@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  public studentForm !: FormGroup;
  studentModel: StudentDTO = new StudentDTO(
    0, '', '', '', '',
    new Date(), '', new AddressDTO(0, ''), []
  );

  public errores: string[] = [];

  constructor(private studentService: StudentService, private router: Router) {
    this.studentForm = this.createFormStudent();
  }

  ngOnInit(): void {
    this.studentService.findStudentById(+localStorage.getItem('studentId')!)
      .subscribe(response => {
        if (response.body) {
          console.log(this.studentModel = response.body)
          this.studentForm.controls['identificationNumber'].setValue(response.body.identificationNumber);
          this.studentForm.controls['identificationType'].setValue(response.body.identificationType);
          this.studentForm.controls['name'].setValue(response.body.name);
          this.studentForm.controls['lastName'].setValue(response.body.lastName);
          this.studentForm.controls['entryDate'].setValue(response.body.entryDate);
          this.studentForm.controls['email'].setValue(response.body.email);
          this.studentForm.controls['address']?.get('ubication')?.setValue(response.body.address.ubication);
          this.studentForm.controls['address']?.get('idStudent')?.setValue(response.body.idPerson);
          this.addPhoneFromResponse(this.studentModel.telephones)
        }
      }
      )
  }

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
      entryDate: new FormControl(''),
      address: new FormGroup({
        ubication: new FormControl('', [Validators.required, Validators.minLength(5), Validators.maxLength(25)])
      }),
      telephones: new FormArray([])
    });
  }
  saveStudent() {
    this.studentModel = Object.assign(this.studentModel, this.studentForm.value);
    console.log(this.studentModel)
    this.studentService.updateStudent(this.studentModel).subscribe(response => {
      this.router.navigate(['/students']);
      swal.fire('Actualizaciín exitosa!', `Estudiante ${response.name} actualizado!`, 'success');
    },
      err => {
        this.errores = err.error.errors as string[];
      }
    );
  }

  removePhone(index: number) {
    const phoneControl = this.studentForm.controls['telephones'] as FormArray;
    phoneControl.removeAt(index);
  }

  addPhoneFromResponse(telephones: TelephoneDTO[]) {
    for (const telephone of telephones) {
      const telephoneForm = new FormGroup({
        telephoneId: new FormControl(telephone.telephoneId),
        type: new FormControl(telephone.type, [Validators.required, Validators.minLength(4)]),
        number: new FormControl(telephone.number, [Validators.required, Validators.pattern('^8[0-9]{5,20}$')])
      });
      (this.telephones as FormArray).push(telephoneForm);
    }
  }

  addPhone() {
    this.telephones.push(new FormGroup({
      type: new FormControl('', [Validators.required, Validators.minLength(4)]),
      number: new FormControl('', [Validators.required, Validators.pattern('^8[0-9]{5,20}$')])
    }));
  }

  goBack() {
    window.history.back();
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
