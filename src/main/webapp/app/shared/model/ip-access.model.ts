export interface IIpAccess {
  id?: number;
  anschlussbilanzierung?: string;
  bssoeorderid?: string;
  dnsprofile?: string;
  filterid?: string;
  fonAktiv?: string;
  ipversion?: string;
  lineid?: string;
  maxdownspeed?: string;
  maxsessionduration?: string;
  maxupspeed?: string;
  mehrfachzugang?: string;
  profileid?: string;
  rechtAufFesteIpadresse?: string;
  toNr?: string;
  umtServiceDataOcssubscriptionid?: string;
  umtServiceDataThrottledownl3?: string;
  umtServiceDataThrottleprofile?: string;
  umtServiceDataThrottleupl3?: string;
  usecase?: string;
  userauthenticationrequired?: string;
}

export class IpAccess implements IIpAccess {
  constructor(
    public id?: number,
    public anschlussbilanzierung?: string,
    public bssoeorderid?: string,
    public dnsprofile?: string,
    public filterid?: string,
    public fonAktiv?: string,
    public ipversion?: string,
    public lineid?: string,
    public maxdownspeed?: string,
    public maxsessionduration?: string,
    public maxupspeed?: string,
    public mehrfachzugang?: string,
    public profileid?: string,
    public rechtAufFesteIpadresse?: string,
    public toNr?: string,
    public umtServiceDataOcssubscriptionid?: string,
    public umtServiceDataThrottledownl3?: string,
    public umtServiceDataThrottleprofile?: string,
    public umtServiceDataThrottleupl3?: string,
    public usecase?: string,
    public userauthenticationrequired?: string
  ) {}
}
