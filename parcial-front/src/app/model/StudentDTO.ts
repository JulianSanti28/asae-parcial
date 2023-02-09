import { PersonDTO } from './PersonDTO';
import { AddressDTO } from './AdressDTO';
import { TelephoneDTO } from './TelephoneDTO';

export class StudentDTO extends PersonDTO {
    entryDate: Date;
    email: string;
    address: AddressDTO;
    telephones: TelephoneDTO[];

    constructor(
        idPerson: number,
        identificationNumber: string,
        identificationType: string,
        name: string,
        lastName: string,
        entryDate: Date,
        email: string,
        address: AddressDTO,
        telephones: TelephoneDTO[]
    ) {
        super(idPerson, identificationNumber, identificationType, name, lastName);
        this.entryDate = entryDate;
        this.email = email;
        this.address = address;
        this.telephones = telephones;
    }
}
