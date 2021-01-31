export interface IIpAccess {
  id?: number;
  anschlussbilanzierung?: string;
  bssoeorderid?: string;
  coanakreaction?: string;
  credentialsrequested?: string;
  delegatedipv6prefix?: string;
  delegatedipv6prefixlength?: string;
  dnsprofile?: string;
  filterid?: string;
  fonAktiv?: string;
  framedipv6prefix?: string;
  framedipv6prefixlength?: string;
  haMSISDN?: string;
  influencesession?: string;
  iptvEnabled?: string;
  ipv4address?: string;
  ipv4netmask?: string;
  ipversion?: string;
  lineid?: string;
  maxdownspeed?: string;
  maxsessionduration?: string;
  maxupspeed?: string;
  mehrfachzugang?: string;
  profileid?: string;
  profilset?: string;
  rechtAufFesteIpadresse?: string;
  reserveprefix?: string;
  teilnehmersperre?: string;
  terminationprofile?: string;
  toNr?: string;
  tunnelprofile?: string;
  umtServiceDataOcssubscriptionid?: string;
  umtServiceDataThrottledownl3?: string;
  umtServiceDataThrottleprofile?: string;
  umtServiceDataThrottleupl3?: string;
  usecase?: string;
  userauthenticationrequired?: string;
  voipIsPresent?: string;
}

export class IpAccess implements IIpAccess {
  constructor(
    public id?: number,
    public anschlussbilanzierung?: string,
    public bssoeorderid?: string,
    public coanakreaction?: string,
    public credentialsrequested?: string,
    public delegatedipv6prefix?: string,
    public delegatedipv6prefixlength?: string,
    public dnsprofile?: string,
    public filterid?: string,
    public fonAktiv?: string,
    public framedipv6prefix?: string,
    public framedipv6prefixlength?: string,
    public haMSISDN?: string,
    public influencesession?: string,
    public iptvEnabled?: string,
    public ipv4address?: string,
    public ipv4netmask?: string,
    public ipversion?: string,
    public lineid?: string,
    public maxdownspeed?: string,
    public maxsessionduration?: string,
    public maxupspeed?: string,
    public mehrfachzugang?: string,
    public profileid?: string,
    public profilset?: string,
    public rechtAufFesteIpadresse?: string,
    public reserveprefix?: string,
    public teilnehmersperre?: string,
    public terminationprofile?: string,
    public toNr?: string,
    public tunnelprofile?: string,
    public umtServiceDataOcssubscriptionid?: string,
    public umtServiceDataThrottledownl3?: string,
    public umtServiceDataThrottleprofile?: string,
    public umtServiceDataThrottleupl3?: string,
    public usecase?: string,
    public userauthenticationrequired?: string,
    public voipIsPresent?: string
  ) {}
}
