export interface IIpCredentails {
  id?: number;
  toNr?: string;
}

export class IpCredentails implements IIpCredentails {
  constructor(public id?: number, public toNr?: string) {}
}
