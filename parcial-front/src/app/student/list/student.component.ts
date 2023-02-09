import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student/student.service';
import { Student } from '../../model/student';
import swal from 'sweetalert2';
import { StudentDTO } from 'src/app/model/StudentDTO';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private studentService: StudentService, private router: Router) {

  }

  students: StudentDTO[] = [];
  errors: string[] = [];

  ngOnInit(): void {
    this.studentService.findAllStudent().subscribe((response) => {
      console.log(response)
      this.students = response;
    }
    )
  }

  editar(student: StudentDTO) {
    localStorage.setItem("studentId", student.idPerson.toString());
    this.router.navigate(["students/details"]);
  }
  eliminar(student: StudentDTO) {
    swal.fire({
      title: 'Eliminar',
      text: '¿Estás seguro de que deseas eliminar este estudiante?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.value) {
        this.studentService.removeStudent(student.idPerson)
          .subscribe(response => {
            console.log(response.status)
            if (response.status === 200) {
              this.students = this.students.filter(s => s !== student);
              swal.fire('Eliminado', 'El estudiante ha sido eliminado.', 'success');
            } else {
              swal.fire('Cancelado', 'No se eliminó el estudiante.', 'error');
            }
          })
      } else {
        swal.fire('Cancelado', 'No se eliminó el estudiante.', 'error');
      }
    });
  }
}
