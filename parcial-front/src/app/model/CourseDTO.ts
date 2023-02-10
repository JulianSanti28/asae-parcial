import { SubjectDTO } from "./SubjectDTO";


export class CourseDTO {
  courseId !: string;
  name !: string;
  period !: number;
  subject !: SubjectDTO;

  constructor(){

  }

  // constructor(courseId: string,name: string, period: number,subject : SubjectDTO) {

  //   this.courseId = courseId;
  //   this.name = name;
  //   this.period = period;
  //   this.subject = subject;
  // }
}
