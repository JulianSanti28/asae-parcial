export class TelephoneDTO {
    telephoneId: number;
    type: string;
    number: string;

    constructor(telephoneId: number, type: string, number: string) {
        this.telephoneId = telephoneId;
        this.type = type;
        this.number = number;
    }
}
