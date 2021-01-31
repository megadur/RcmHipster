package com.dtit.tm.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A IpAccess.
 */
@Entity
@Table(name = "ip_access")
public class IpAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "anschlussbilanzierung")
    private String anschlussbilanzierung;

    @Column(name = "bssoeorderid")
    private String bssoeorderid;

    @Column(name = "coanakreaction")
    private String coanakreaction;

    @Column(name = "credentialsrequested")
    private String credentialsrequested;

    @Column(name = "delegatedipv_6_prefix")
    private String delegatedipv6prefix;

    @Column(name = "delegatedipv_6_prefixlength")
    private String delegatedipv6prefixlength;

    @Column(name = "dnsprofile")
    private String dnsprofile;

    @Column(name = "filterid")
    private String filterid;

    @Column(name = "fon_aktiv")
    private String fonAktiv;

    @Column(name = "framedipv_6_prefix")
    private String framedipv6prefix;

    @Column(name = "framedipv_6_prefixlength")
    private String framedipv6prefixlength;

    @Column(name = "ha_msisdn")
    private String haMSISDN;

    @Column(name = "influencesession")
    private String influencesession;

    @Column(name = "iptv_enabled")
    private String iptvEnabled;

    @Column(name = "ipv_4_address")
    private String ipv4address;

    @Column(name = "ipv_4_netmask")
    private String ipv4netmask;

    @Column(name = "ipversion")
    private String ipversion;

    @Column(name = "lineid")
    private String lineid;

    @Column(name = "maxdownspeed")
    private String maxdownspeed;

    @Column(name = "maxsessionduration")
    private String maxsessionduration;

    @Column(name = "maxupspeed")
    private String maxupspeed;

    @Column(name = "mehrfachzugang")
    private String mehrfachzugang;

    @Column(name = "profileid")
    private String profileid;

    @Column(name = "profilset")
    private String profilset;

    @Column(name = "recht_auf_feste_ipadresse")
    private String rechtAufFesteIpadresse;

    @Column(name = "reserveprefix")
    private String reserveprefix;

    @Column(name = "teilnehmersperre")
    private String teilnehmersperre;

    @Column(name = "terminationprofile")
    private String terminationprofile;

    @Column(name = "to_nr")
    private String toNr;

    @Column(name = "tunnelprofile")
    private String tunnelprofile;

    @Column(name = "umt_service_data_ocssubscriptionid")
    private String umtServiceDataOcssubscriptionid;

    @Column(name = "umt_service_data_throttledownl_3")
    private String umtServiceDataThrottledownl3;

    @Column(name = "umt_service_data_throttleprofile")
    private String umtServiceDataThrottleprofile;

    @Column(name = "umt_service_data_throttleupl_3")
    private String umtServiceDataThrottleupl3;

    @Column(name = "usecase")
    private String usecase;

    @Column(name = "userauthenticationrequired")
    private String userauthenticationrequired;

    @Column(name = "voip_is_present")
    private String voipIsPresent;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnschlussbilanzierung() {
        return anschlussbilanzierung;
    }

    public IpAccess anschlussbilanzierung(String anschlussbilanzierung) {
        this.anschlussbilanzierung = anschlussbilanzierung;
        return this;
    }

    public void setAnschlussbilanzierung(String anschlussbilanzierung) {
        this.anschlussbilanzierung = anschlussbilanzierung;
    }

    public String getBssoeorderid() {
        return bssoeorderid;
    }

    public IpAccess bssoeorderid(String bssoeorderid) {
        this.bssoeorderid = bssoeorderid;
        return this;
    }

    public void setBssoeorderid(String bssoeorderid) {
        this.bssoeorderid = bssoeorderid;
    }

    public String getCoanakreaction() {
        return coanakreaction;
    }

    public IpAccess coanakreaction(String coanakreaction) {
        this.coanakreaction = coanakreaction;
        return this;
    }

    public void setCoanakreaction(String coanakreaction) {
        this.coanakreaction = coanakreaction;
    }

    public String getCredentialsrequested() {
        return credentialsrequested;
    }

    public IpAccess credentialsrequested(String credentialsrequested) {
        this.credentialsrequested = credentialsrequested;
        return this;
    }

    public void setCredentialsrequested(String credentialsrequested) {
        this.credentialsrequested = credentialsrequested;
    }

    public String getDelegatedipv6prefix() {
        return delegatedipv6prefix;
    }

    public IpAccess delegatedipv6prefix(String delegatedipv6prefix) {
        this.delegatedipv6prefix = delegatedipv6prefix;
        return this;
    }

    public void setDelegatedipv6prefix(String delegatedipv6prefix) {
        this.delegatedipv6prefix = delegatedipv6prefix;
    }

    public String getDelegatedipv6prefixlength() {
        return delegatedipv6prefixlength;
    }

    public IpAccess delegatedipv6prefixlength(String delegatedipv6prefixlength) {
        this.delegatedipv6prefixlength = delegatedipv6prefixlength;
        return this;
    }

    public void setDelegatedipv6prefixlength(String delegatedipv6prefixlength) {
        this.delegatedipv6prefixlength = delegatedipv6prefixlength;
    }

    public String getDnsprofile() {
        return dnsprofile;
    }

    public IpAccess dnsprofile(String dnsprofile) {
        this.dnsprofile = dnsprofile;
        return this;
    }

    public void setDnsprofile(String dnsprofile) {
        this.dnsprofile = dnsprofile;
    }

    public String getFilterid() {
        return filterid;
    }

    public IpAccess filterid(String filterid) {
        this.filterid = filterid;
        return this;
    }

    public void setFilterid(String filterid) {
        this.filterid = filterid;
    }

    public String getFonAktiv() {
        return fonAktiv;
    }

    public IpAccess fonAktiv(String fonAktiv) {
        this.fonAktiv = fonAktiv;
        return this;
    }

    public void setFonAktiv(String fonAktiv) {
        this.fonAktiv = fonAktiv;
    }

    public String getFramedipv6prefix() {
        return framedipv6prefix;
    }

    public IpAccess framedipv6prefix(String framedipv6prefix) {
        this.framedipv6prefix = framedipv6prefix;
        return this;
    }

    public void setFramedipv6prefix(String framedipv6prefix) {
        this.framedipv6prefix = framedipv6prefix;
    }

    public String getFramedipv6prefixlength() {
        return framedipv6prefixlength;
    }

    public IpAccess framedipv6prefixlength(String framedipv6prefixlength) {
        this.framedipv6prefixlength = framedipv6prefixlength;
        return this;
    }

    public void setFramedipv6prefixlength(String framedipv6prefixlength) {
        this.framedipv6prefixlength = framedipv6prefixlength;
    }

    public String getHaMSISDN() {
        return haMSISDN;
    }

    public IpAccess haMSISDN(String haMSISDN) {
        this.haMSISDN = haMSISDN;
        return this;
    }

    public void setHaMSISDN(String haMSISDN) {
        this.haMSISDN = haMSISDN;
    }

    public String getInfluencesession() {
        return influencesession;
    }

    public IpAccess influencesession(String influencesession) {
        this.influencesession = influencesession;
        return this;
    }

    public void setInfluencesession(String influencesession) {
        this.influencesession = influencesession;
    }

    public String getIptvEnabled() {
        return iptvEnabled;
    }

    public IpAccess iptvEnabled(String iptvEnabled) {
        this.iptvEnabled = iptvEnabled;
        return this;
    }

    public void setIptvEnabled(String iptvEnabled) {
        this.iptvEnabled = iptvEnabled;
    }

    public String getIpv4address() {
        return ipv4address;
    }

    public IpAccess ipv4address(String ipv4address) {
        this.ipv4address = ipv4address;
        return this;
    }

    public void setIpv4address(String ipv4address) {
        this.ipv4address = ipv4address;
    }

    public String getIpv4netmask() {
        return ipv4netmask;
    }

    public IpAccess ipv4netmask(String ipv4netmask) {
        this.ipv4netmask = ipv4netmask;
        return this;
    }

    public void setIpv4netmask(String ipv4netmask) {
        this.ipv4netmask = ipv4netmask;
    }

    public String getIpversion() {
        return ipversion;
    }

    public IpAccess ipversion(String ipversion) {
        this.ipversion = ipversion;
        return this;
    }

    public void setIpversion(String ipversion) {
        this.ipversion = ipversion;
    }

    public String getLineid() {
        return lineid;
    }

    public IpAccess lineid(String lineid) {
        this.lineid = lineid;
        return this;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getMaxdownspeed() {
        return maxdownspeed;
    }

    public IpAccess maxdownspeed(String maxdownspeed) {
        this.maxdownspeed = maxdownspeed;
        return this;
    }

    public void setMaxdownspeed(String maxdownspeed) {
        this.maxdownspeed = maxdownspeed;
    }

    public String getMaxsessionduration() {
        return maxsessionduration;
    }

    public IpAccess maxsessionduration(String maxsessionduration) {
        this.maxsessionduration = maxsessionduration;
        return this;
    }

    public void setMaxsessionduration(String maxsessionduration) {
        this.maxsessionduration = maxsessionduration;
    }

    public String getMaxupspeed() {
        return maxupspeed;
    }

    public IpAccess maxupspeed(String maxupspeed) {
        this.maxupspeed = maxupspeed;
        return this;
    }

    public void setMaxupspeed(String maxupspeed) {
        this.maxupspeed = maxupspeed;
    }

    public String getMehrfachzugang() {
        return mehrfachzugang;
    }

    public IpAccess mehrfachzugang(String mehrfachzugang) {
        this.mehrfachzugang = mehrfachzugang;
        return this;
    }

    public void setMehrfachzugang(String mehrfachzugang) {
        this.mehrfachzugang = mehrfachzugang;
    }

    public String getProfileid() {
        return profileid;
    }

    public IpAccess profileid(String profileid) {
        this.profileid = profileid;
        return this;
    }

    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    public String getProfilset() {
        return profilset;
    }

    public IpAccess profilset(String profilset) {
        this.profilset = profilset;
        return this;
    }

    public void setProfilset(String profilset) {
        this.profilset = profilset;
    }

    public String getRechtAufFesteIpadresse() {
        return rechtAufFesteIpadresse;
    }

    public IpAccess rechtAufFesteIpadresse(String rechtAufFesteIpadresse) {
        this.rechtAufFesteIpadresse = rechtAufFesteIpadresse;
        return this;
    }

    public void setRechtAufFesteIpadresse(String rechtAufFesteIpadresse) {
        this.rechtAufFesteIpadresse = rechtAufFesteIpadresse;
    }

    public String getReserveprefix() {
        return reserveprefix;
    }

    public IpAccess reserveprefix(String reserveprefix) {
        this.reserveprefix = reserveprefix;
        return this;
    }

    public void setReserveprefix(String reserveprefix) {
        this.reserveprefix = reserveprefix;
    }

    public String getTeilnehmersperre() {
        return teilnehmersperre;
    }

    public IpAccess teilnehmersperre(String teilnehmersperre) {
        this.teilnehmersperre = teilnehmersperre;
        return this;
    }

    public void setTeilnehmersperre(String teilnehmersperre) {
        this.teilnehmersperre = teilnehmersperre;
    }

    public String getTerminationprofile() {
        return terminationprofile;
    }

    public IpAccess terminationprofile(String terminationprofile) {
        this.terminationprofile = terminationprofile;
        return this;
    }

    public void setTerminationprofile(String terminationprofile) {
        this.terminationprofile = terminationprofile;
    }

    public String getToNr() {
        return toNr;
    }

    public IpAccess toNr(String toNr) {
        this.toNr = toNr;
        return this;
    }

    public void setToNr(String toNr) {
        this.toNr = toNr;
    }

    public String getTunnelprofile() {
        return tunnelprofile;
    }

    public IpAccess tunnelprofile(String tunnelprofile) {
        this.tunnelprofile = tunnelprofile;
        return this;
    }

    public void setTunnelprofile(String tunnelprofile) {
        this.tunnelprofile = tunnelprofile;
    }

    public String getUmtServiceDataOcssubscriptionid() {
        return umtServiceDataOcssubscriptionid;
    }

    public IpAccess umtServiceDataOcssubscriptionid(String umtServiceDataOcssubscriptionid) {
        this.umtServiceDataOcssubscriptionid = umtServiceDataOcssubscriptionid;
        return this;
    }

    public void setUmtServiceDataOcssubscriptionid(String umtServiceDataOcssubscriptionid) {
        this.umtServiceDataOcssubscriptionid = umtServiceDataOcssubscriptionid;
    }

    public String getUmtServiceDataThrottledownl3() {
        return umtServiceDataThrottledownl3;
    }

    public IpAccess umtServiceDataThrottledownl3(String umtServiceDataThrottledownl3) {
        this.umtServiceDataThrottledownl3 = umtServiceDataThrottledownl3;
        return this;
    }

    public void setUmtServiceDataThrottledownl3(String umtServiceDataThrottledownl3) {
        this.umtServiceDataThrottledownl3 = umtServiceDataThrottledownl3;
    }

    public String getUmtServiceDataThrottleprofile() {
        return umtServiceDataThrottleprofile;
    }

    public IpAccess umtServiceDataThrottleprofile(String umtServiceDataThrottleprofile) {
        this.umtServiceDataThrottleprofile = umtServiceDataThrottleprofile;
        return this;
    }

    public void setUmtServiceDataThrottleprofile(String umtServiceDataThrottleprofile) {
        this.umtServiceDataThrottleprofile = umtServiceDataThrottleprofile;
    }

    public String getUmtServiceDataThrottleupl3() {
        return umtServiceDataThrottleupl3;
    }

    public IpAccess umtServiceDataThrottleupl3(String umtServiceDataThrottleupl3) {
        this.umtServiceDataThrottleupl3 = umtServiceDataThrottleupl3;
        return this;
    }

    public void setUmtServiceDataThrottleupl3(String umtServiceDataThrottleupl3) {
        this.umtServiceDataThrottleupl3 = umtServiceDataThrottleupl3;
    }

    public String getUsecase() {
        return usecase;
    }

    public IpAccess usecase(String usecase) {
        this.usecase = usecase;
        return this;
    }

    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }

    public String getUserauthenticationrequired() {
        return userauthenticationrequired;
    }

    public IpAccess userauthenticationrequired(String userauthenticationrequired) {
        this.userauthenticationrequired = userauthenticationrequired;
        return this;
    }

    public void setUserauthenticationrequired(String userauthenticationrequired) {
        this.userauthenticationrequired = userauthenticationrequired;
    }

    public String getVoipIsPresent() {
        return voipIsPresent;
    }

    public IpAccess voipIsPresent(String voipIsPresent) {
        this.voipIsPresent = voipIsPresent;
        return this;
    }

    public void setVoipIsPresent(String voipIsPresent) {
        this.voipIsPresent = voipIsPresent;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IpAccess)) {
            return false;
        }
        return id != null && id.equals(((IpAccess) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IpAccess{" +
            "id=" + getId() +
            ", anschlussbilanzierung='" + getAnschlussbilanzierung() + "'" +
            ", bssoeorderid='" + getBssoeorderid() + "'" +
            ", coanakreaction='" + getCoanakreaction() + "'" +
            ", credentialsrequested='" + getCredentialsrequested() + "'" +
            ", delegatedipv6prefix='" + getDelegatedipv6prefix() + "'" +
            ", delegatedipv6prefixlength='" + getDelegatedipv6prefixlength() + "'" +
            ", dnsprofile='" + getDnsprofile() + "'" +
            ", filterid='" + getFilterid() + "'" +
            ", fonAktiv='" + getFonAktiv() + "'" +
            ", framedipv6prefix='" + getFramedipv6prefix() + "'" +
            ", framedipv6prefixlength='" + getFramedipv6prefixlength() + "'" +
            ", haMSISDN='" + getHaMSISDN() + "'" +
            ", influencesession='" + getInfluencesession() + "'" +
            ", iptvEnabled='" + getIptvEnabled() + "'" +
            ", ipv4address='" + getIpv4address() + "'" +
            ", ipv4netmask='" + getIpv4netmask() + "'" +
            ", ipversion='" + getIpversion() + "'" +
            ", lineid='" + getLineid() + "'" +
            ", maxdownspeed='" + getMaxdownspeed() + "'" +
            ", maxsessionduration='" + getMaxsessionduration() + "'" +
            ", maxupspeed='" + getMaxupspeed() + "'" +
            ", mehrfachzugang='" + getMehrfachzugang() + "'" +
            ", profileid='" + getProfileid() + "'" +
            ", profilset='" + getProfilset() + "'" +
            ", rechtAufFesteIpadresse='" + getRechtAufFesteIpadresse() + "'" +
            ", reserveprefix='" + getReserveprefix() + "'" +
            ", teilnehmersperre='" + getTeilnehmersperre() + "'" +
            ", terminationprofile='" + getTerminationprofile() + "'" +
            ", toNr='" + getToNr() + "'" +
            ", tunnelprofile='" + getTunnelprofile() + "'" +
            ", umtServiceDataOcssubscriptionid='" + getUmtServiceDataOcssubscriptionid() + "'" +
            ", umtServiceDataThrottledownl3='" + getUmtServiceDataThrottledownl3() + "'" +
            ", umtServiceDataThrottleprofile='" + getUmtServiceDataThrottleprofile() + "'" +
            ", umtServiceDataThrottleupl3='" + getUmtServiceDataThrottleupl3() + "'" +
            ", usecase='" + getUsecase() + "'" +
            ", userauthenticationrequired='" + getUserauthenticationrequired() + "'" +
            ", voipIsPresent='" + getVoipIsPresent() + "'" +
            "}";
    }
}
