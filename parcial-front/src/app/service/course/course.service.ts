import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { CourseDTO } from 'src/app/model/CourseDTO';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private endPoint:string =  'api/course'

  constructor(private http: HttpClient) { }

  getAllCourse():Observable<CourseDTO[]>{
    return this.http.get<CourseDTO[]>(this.endPoint).pipe(
      catchError( (e) => {
        console.log('Error obteniendo todos los Estudiantes', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  save(course:CourseDTO):Observable<CourseDTO>{
    return this.http.post<CourseDTO>(this.endPoint,course).pipe(
      catchError(
        e =>{
          if(e.status == 400){
            return throwError(e);
          }
          console.log(e.error.mensaje);
          Swal.fire('Error al crear el Curso',e.error.mensaje,'error');
          return throwError(e);
        }
      )
    );
  }

  delete(id:string):Observable<any>{
    return this.http.delete(this.endPoint+'/'+id,
    {'responseType': 'text'}
    ).pipe(
      catchError((e) =>{
        console.log('Error eliminando el estudiante', e.error.mensaje, 'error');
        return throwError(e);
      })
    )
  }

  getCourseByID(id:string):Observable<CourseDTO>{
    return this.http.get<CourseDTO>(this.endPoint+"/"+id).pipe(
      catchError( (e) => {
        console.log('Error obteniendo el curso', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

}
