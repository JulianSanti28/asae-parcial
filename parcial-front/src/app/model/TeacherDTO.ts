import { PersonDTO } from "./PersonDTO";

export class TeacherDTO extends PersonDTO{
  university:string;
  teacherType:string;
  salary:number;

  constructor(
    idPerson: number,
    identificationNumber: string,
    identificationType: string,
    name: string,
    lastName: string,
    university:string,
    teacherType:string,
    salary:number
) {
    super(idPerson, identificationNumber, identificationType, name, lastName);
    this.university = university;
    this.teacherType = teacherType;
    this.salary = salary;
}
}
