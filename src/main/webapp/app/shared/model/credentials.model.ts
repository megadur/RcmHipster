export interface ICredentials {
  id?: number;
  tonr?: string;
  ask?: string;
  password?: string;
}

export class Credentials implements ICredentials {
  constructor(public id?: number, public tonr?: string, public ask?: string, public password?: string) {}
}
