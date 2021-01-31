export interface ISubscriber {
  id?: number;
  asskeng?: string;
  calid?: string;
  dlgipv6Prefix?: string;
  dlgipv6Prefixlen?: string;
  dnsProfile?: string;
  errorelement?: string;
  errormessage?: string;
  errorvalue?: string;
  filterid?: string;
  frmdipv6Prefix?: string;
  frmdipv6Prefixlen?: string;
  ipaddress?: string;
  ipnetmask?: string;
  ipversion?: string;
  keyid?: string;
  maxDownL3?: string;
  maxSessionDuration?: string;
  maxUpL3?: string;
  mfzg?: string;
  msisdn?: string;
  netprofileid?: string;
  origin?: string;
  passwort?: string;
  passwortEnc?: string;
  policyGroup?: string;
  profilset?: string;
  rc?: string;
  rectime?: string;
  requestID?: string;
  reserveprefix?: string;
  returnmessage?: string;
  rsptime?: string;
  tlnnr?: string;
  tlnsps?: string;
  tunnelProfile?: string;
  umtServiceData?: string;
  userAuthRequired?: string;
}

export class Subscriber implements ISubscriber {
  constructor(
    public id?: number,
    public asskeng?: string,
    public calid?: string,
    public dlgipv6Prefix?: string,
    public dlgipv6Prefixlen?: string,
    public dnsProfile?: string,
    public errorelement?: string,
    public errormessage?: string,
    public errorvalue?: string,
    public filterid?: string,
    public frmdipv6Prefix?: string,
    public frmdipv6Prefixlen?: string,
    public ipaddress?: string,
    public ipnetmask?: string,
    public ipversion?: string,
    public keyid?: string,
    public maxDownL3?: string,
    public maxSessionDuration?: string,
    public maxUpL3?: string,
    public mfzg?: string,
    public msisdn?: string,
    public netprofileid?: string,
    public origin?: string,
    public passwort?: string,
    public passwortEnc?: string,
    public policyGroup?: string,
    public profilset?: string,
    public rc?: string,
    public rectime?: string,
    public requestID?: string,
    public reserveprefix?: string,
    public returnmessage?: string,
    public rsptime?: string,
    public tlnnr?: string,
    public tlnsps?: string,
    public tunnelProfile?: string,
    public umtServiceData?: string,
    public userAuthRequired?: string
  ) {}
}
