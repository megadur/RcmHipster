export interface ISubscriber {
  id?: number;
  asskeng?: string;
  calid?: string;
  dnsProfile?: string;
  errorelement?: string;
  errormessage?: string;
  errorvalue?: string;
  ipversion?: string;
  keyid?: string;
  maxDownL3?: string;
  maxSessionDuration?: string;
  maxUpL3?: string;
  mfzg?: string;
  netprofileid?: string;
  origin?: string;
  passwort?: string;
  passwortEnc?: string;
  policyGroup?: string;
  profilset?: string;
  rc?: string;
  rectime?: string;
  requestID?: string;
  returnmessage?: string;
  rsptime?: string;
  tlnnr?: string;
  tlnsps?: string;
  userAuthRequired?: string;
}

export class Subscriber implements ISubscriber {
  constructor(
    public id?: number,
    public asskeng?: string,
    public calid?: string,
    public dnsProfile?: string,
    public errorelement?: string,
    public errormessage?: string,
    public errorvalue?: string,
    public ipversion?: string,
    public keyid?: string,
    public maxDownL3?: string,
    public maxSessionDuration?: string,
    public maxUpL3?: string,
    public mfzg?: string,
    public netprofileid?: string,
    public origin?: string,
    public passwort?: string,
    public passwortEnc?: string,
    public policyGroup?: string,
    public profilset?: string,
    public rc?: string,
    public rectime?: string,
    public requestID?: string,
    public returnmessage?: string,
    public rsptime?: string,
    public tlnnr?: string,
    public tlnsps?: string,
    public userAuthRequired?: string
  ) {}
}
