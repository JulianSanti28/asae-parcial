import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'src/app/service/student/student.service';
import { Student } from '../../model/student';
import swal from 'sweetalert2';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private studentService: StudentService, private router: Router) {

  }

  students: Student[] = [];
  errors: string[] = [];

  ngOnInit(): void {
    this.studentService.findAllStudent().subscribe((response) => {

      this.students = response;

    }
    )
  }

  editar(student: Student) {
    console.log(student);
    localStorage.setItem("studentId", student.code.toString());
    this.router.navigate(["students/details"]);
  }
  eliminar(student: Student) {
    swal.fire({
      title: 'Eliminar',
      text: '¿Estás seguro de que deseas eliminar este estudiante?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.value) {
        this.studentService.removeStudent(student.code)
          .subscribe(response => {
            console.log(response.status)
            if (response.status === 200) {
              swal.fire('Eliminado', 'El estudiante ha sido eliminado.', 'success');
              location.reload();
            } else {
              swal.fire('Cancelado', 'No se eliminó el estudiante.', 'error');
              location.reload();
            }
          })
      } else {
        swal.fire('Cancelado', 'No se eliminó el estudiante.', 'error');
      }
    });
  }
}
