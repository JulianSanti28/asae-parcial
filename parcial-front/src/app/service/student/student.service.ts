import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { StudentDTO } from '../../model/StudentDTO';
import { Response } from '../../model/response';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  urlPath = 'http://localhost:8081/api/student';
  errors: string[];

  constructor(private httpClient: HttpClient) {
    this.errors = [];
   }

  saveStudent(student: StudentDTO) {
    return this.httpClient.post<StudentDTO>(this.urlPath, student).pipe(
      catchError((err: HttpErrorResponse) => {
        this.errors = err.error;
        return throwError(err);
      })
    );
  }

  updateStudent(student: StudentDTO) {
    return this.httpClient.put<StudentDTO>(`${this.urlPath}?id=${student.idPerson}`, student).pipe(
      catchError((err: HttpErrorResponse) => {
        this.errors = err.error;
        return throwError(err);
      })
    );
  }
  findAllStudent(){
    return this.httpClient.get<StudentDTO[]>(this.urlPath).pipe(
      catchError(err => {
        return throwError(err);
      })
    )
  }

  findStudentById(code: number){
    return this.httpClient.get<StudentDTO>(`${this.urlPath}/${code}`, { observe: 'response' });
  }

  removeStudent(code: number) {
    return this.httpClient.delete<Response>(`${this.urlPath}?id=${code}`, { observe: 'response' });
  }
}
