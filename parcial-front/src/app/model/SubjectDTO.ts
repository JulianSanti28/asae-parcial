import { CourseDTO } from "./CourseDTO";
import { TeacherDTO } from "./TeacherDTO";

export class SubjectDTO{
  subjectId !: number;
  name?:string;
  courses ?: CourseDTO[];
  teachers !:TeacherDTO [];

  constructor(){

  }

}
