import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { TeacherDTO } from 'src/app/model/TeacherDTO';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  urlPath = 'api/teacher';
  errors: string[];

  constructor(private httpClient: HttpClient) {
    this.errors = [];
   }

  findAll(){
    return this.httpClient.get<TeacherDTO[]>(this.urlPath).pipe(
      catchError(err => {
        return throwError(err);
      })
    )
  }
  saveTeacher(teacher: TeacherDTO){
    return this.httpClient.post<TeacherDTO>(this.urlPath,teacher).pipe(
      catchError((err:HttpErrorResponse)=>{
        this.errors = err.error;
        return throwError(err);
      })
    )
  }
}
