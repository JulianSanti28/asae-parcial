export class PersonDTO {
    idPerson: number;
    identificationNumber: string;
    identificationType: string;
    name: string;
    lastName: string;

    constructor(
        idPerson: number,
        identificationNumber: string,
        identificationType: string,
        name: string,
        lastName: string
    ) {
        this.idPerson = idPerson;
        this.identificationNumber = identificationNumber;
        this.identificationType = identificationType;
        this.name = name;
        this.lastName = lastName;
    }
}
