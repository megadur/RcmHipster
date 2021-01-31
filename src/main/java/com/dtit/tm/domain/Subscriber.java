package com.dtit.tm.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Subscriber.
 */
@Entity
@Table(name = "subscriber")
public class Subscriber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asskeng")
    private String asskeng;

    @Column(name = "calid")
    private String calid;

    @Column(name = "dlgipv_6_prefix")
    private String dlgipv6Prefix;

    @Column(name = "dlgipv_6_prefixlen")
    private String dlgipv6Prefixlen;

    @Column(name = "dns_profile")
    private String dnsProfile;

    @Column(name = "errorelement")
    private String errorelement;

    @Column(name = "errormessage")
    private String errormessage;

    @Column(name = "errorvalue")
    private String errorvalue;

    @Column(name = "filterid")
    private String filterid;

    @Column(name = "frmdipv_6_prefix")
    private String frmdipv6Prefix;

    @Column(name = "frmdipv_6_prefixlen")
    private String frmdipv6Prefixlen;

    @Column(name = "ipaddress")
    private String ipaddress;

    @Column(name = "ipnetmask")
    private String ipnetmask;

    @Column(name = "ipversion")
    private String ipversion;

    @Column(name = "keyid")
    private String keyid;

    @Column(name = "max_down_l_3")
    private String maxDownL3;

    @Column(name = "max_session_duration")
    private String maxSessionDuration;

    @Column(name = "max_up_l_3")
    private String maxUpL3;

    @Column(name = "mfzg")
    private String mfzg;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "netprofileid")
    private String netprofileid;

    @Column(name = "origin")
    private String origin;

    @Column(name = "passwort")
    private String passwort;

    @Column(name = "passwort_enc")
    private String passwortEnc;

    @Column(name = "policy_group")
    private String policyGroup;

    @Column(name = "profilset")
    private String profilset;

    @Column(name = "rc")
    private String rc;

    @Column(name = "rectime")
    private String rectime;

    @Column(name = "request_id")
    private String requestID;

    @Column(name = "reserveprefix")
    private String reserveprefix;

    @Column(name = "returnmessage")
    private String returnmessage;

    @Column(name = "rsptime")
    private String rsptime;

    @Column(name = "tlnnr")
    private String tlnnr;

    @Column(name = "tlnsps")
    private String tlnsps;

    @Column(name = "tunnel_profile")
    private String tunnelProfile;

    @Column(name = "umt_service_data")
    private String umtServiceData;

    @Column(name = "user_auth_required")
    private String userAuthRequired;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsskeng() {
        return asskeng;
    }

    public Subscriber asskeng(String asskeng) {
        this.asskeng = asskeng;
        return this;
    }

    public void setAsskeng(String asskeng) {
        this.asskeng = asskeng;
    }

    public String getCalid() {
        return calid;
    }

    public Subscriber calid(String calid) {
        this.calid = calid;
        return this;
    }

    public void setCalid(String calid) {
        this.calid = calid;
    }

    public String getDlgipv6Prefix() {
        return dlgipv6Prefix;
    }

    public Subscriber dlgipv6Prefix(String dlgipv6Prefix) {
        this.dlgipv6Prefix = dlgipv6Prefix;
        return this;
    }

    public void setDlgipv6Prefix(String dlgipv6Prefix) {
        this.dlgipv6Prefix = dlgipv6Prefix;
    }

    public String getDlgipv6Prefixlen() {
        return dlgipv6Prefixlen;
    }

    public Subscriber dlgipv6Prefixlen(String dlgipv6Prefixlen) {
        this.dlgipv6Prefixlen = dlgipv6Prefixlen;
        return this;
    }

    public void setDlgipv6Prefixlen(String dlgipv6Prefixlen) {
        this.dlgipv6Prefixlen = dlgipv6Prefixlen;
    }

    public String getDnsProfile() {
        return dnsProfile;
    }

    public Subscriber dnsProfile(String dnsProfile) {
        this.dnsProfile = dnsProfile;
        return this;
    }

    public void setDnsProfile(String dnsProfile) {
        this.dnsProfile = dnsProfile;
    }

    public String getErrorelement() {
        return errorelement;
    }

    public Subscriber errorelement(String errorelement) {
        this.errorelement = errorelement;
        return this;
    }

    public void setErrorelement(String errorelement) {
        this.errorelement = errorelement;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public Subscriber errormessage(String errormessage) {
        this.errormessage = errormessage;
        return this;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrorvalue() {
        return errorvalue;
    }

    public Subscriber errorvalue(String errorvalue) {
        this.errorvalue = errorvalue;
        return this;
    }

    public void setErrorvalue(String errorvalue) {
        this.errorvalue = errorvalue;
    }

    public String getFilterid() {
        return filterid;
    }

    public Subscriber filterid(String filterid) {
        this.filterid = filterid;
        return this;
    }

    public void setFilterid(String filterid) {
        this.filterid = filterid;
    }

    public String getFrmdipv6Prefix() {
        return frmdipv6Prefix;
    }

    public Subscriber frmdipv6Prefix(String frmdipv6Prefix) {
        this.frmdipv6Prefix = frmdipv6Prefix;
        return this;
    }

    public void setFrmdipv6Prefix(String frmdipv6Prefix) {
        this.frmdipv6Prefix = frmdipv6Prefix;
    }

    public String getFrmdipv6Prefixlen() {
        return frmdipv6Prefixlen;
    }

    public Subscriber frmdipv6Prefixlen(String frmdipv6Prefixlen) {
        this.frmdipv6Prefixlen = frmdipv6Prefixlen;
        return this;
    }

    public void setFrmdipv6Prefixlen(String frmdipv6Prefixlen) {
        this.frmdipv6Prefixlen = frmdipv6Prefixlen;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public Subscriber ipaddress(String ipaddress) {
        this.ipaddress = ipaddress;
        return this;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getIpnetmask() {
        return ipnetmask;
    }

    public Subscriber ipnetmask(String ipnetmask) {
        this.ipnetmask = ipnetmask;
        return this;
    }

    public void setIpnetmask(String ipnetmask) {
        this.ipnetmask = ipnetmask;
    }

    public String getIpversion() {
        return ipversion;
    }

    public Subscriber ipversion(String ipversion) {
        this.ipversion = ipversion;
        return this;
    }

    public void setIpversion(String ipversion) {
        this.ipversion = ipversion;
    }

    public String getKeyid() {
        return keyid;
    }

    public Subscriber keyid(String keyid) {
        this.keyid = keyid;
        return this;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getMaxDownL3() {
        return maxDownL3;
    }

    public Subscriber maxDownL3(String maxDownL3) {
        this.maxDownL3 = maxDownL3;
        return this;
    }

    public void setMaxDownL3(String maxDownL3) {
        this.maxDownL3 = maxDownL3;
    }

    public String getMaxSessionDuration() {
        return maxSessionDuration;
    }

    public Subscriber maxSessionDuration(String maxSessionDuration) {
        this.maxSessionDuration = maxSessionDuration;
        return this;
    }

    public void setMaxSessionDuration(String maxSessionDuration) {
        this.maxSessionDuration = maxSessionDuration;
    }

    public String getMaxUpL3() {
        return maxUpL3;
    }

    public Subscriber maxUpL3(String maxUpL3) {
        this.maxUpL3 = maxUpL3;
        return this;
    }

    public void setMaxUpL3(String maxUpL3) {
        this.maxUpL3 = maxUpL3;
    }

    public String getMfzg() {
        return mfzg;
    }

    public Subscriber mfzg(String mfzg) {
        this.mfzg = mfzg;
        return this;
    }

    public void setMfzg(String mfzg) {
        this.mfzg = mfzg;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public Subscriber msisdn(String msisdn) {
        this.msisdn = msisdn;
        return this;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNetprofileid() {
        return netprofileid;
    }

    public Subscriber netprofileid(String netprofileid) {
        this.netprofileid = netprofileid;
        return this;
    }

    public void setNetprofileid(String netprofileid) {
        this.netprofileid = netprofileid;
    }

    public String getOrigin() {
        return origin;
    }

    public Subscriber origin(String origin) {
        this.origin = origin;
        return this;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPasswort() {
        return passwort;
    }

    public Subscriber passwort(String passwort) {
        this.passwort = passwort;
        return this;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getPasswortEnc() {
        return passwortEnc;
    }

    public Subscriber passwortEnc(String passwortEnc) {
        this.passwortEnc = passwortEnc;
        return this;
    }

    public void setPasswortEnc(String passwortEnc) {
        this.passwortEnc = passwortEnc;
    }

    public String getPolicyGroup() {
        return policyGroup;
    }

    public Subscriber policyGroup(String policyGroup) {
        this.policyGroup = policyGroup;
        return this;
    }

    public void setPolicyGroup(String policyGroup) {
        this.policyGroup = policyGroup;
    }

    public String getProfilset() {
        return profilset;
    }

    public Subscriber profilset(String profilset) {
        this.profilset = profilset;
        return this;
    }

    public void setProfilset(String profilset) {
        this.profilset = profilset;
    }

    public String getRc() {
        return rc;
    }

    public Subscriber rc(String rc) {
        this.rc = rc;
        return this;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRectime() {
        return rectime;
    }

    public Subscriber rectime(String rectime) {
        this.rectime = rectime;
        return this;
    }

    public void setRectime(String rectime) {
        this.rectime = rectime;
    }

    public String getRequestID() {
        return requestID;
    }

    public Subscriber requestID(String requestID) {
        this.requestID = requestID;
        return this;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getReserveprefix() {
        return reserveprefix;
    }

    public Subscriber reserveprefix(String reserveprefix) {
        this.reserveprefix = reserveprefix;
        return this;
    }

    public void setReserveprefix(String reserveprefix) {
        this.reserveprefix = reserveprefix;
    }

    public String getReturnmessage() {
        return returnmessage;
    }

    public Subscriber returnmessage(String returnmessage) {
        this.returnmessage = returnmessage;
        return this;
    }

    public void setReturnmessage(String returnmessage) {
        this.returnmessage = returnmessage;
    }

    public String getRsptime() {
        return rsptime;
    }

    public Subscriber rsptime(String rsptime) {
        this.rsptime = rsptime;
        return this;
    }

    public void setRsptime(String rsptime) {
        this.rsptime = rsptime;
    }

    public String getTlnnr() {
        return tlnnr;
    }

    public Subscriber tlnnr(String tlnnr) {
        this.tlnnr = tlnnr;
        return this;
    }

    public void setTlnnr(String tlnnr) {
        this.tlnnr = tlnnr;
    }

    public String getTlnsps() {
        return tlnsps;
    }

    public Subscriber tlnsps(String tlnsps) {
        this.tlnsps = tlnsps;
        return this;
    }

    public void setTlnsps(String tlnsps) {
        this.tlnsps = tlnsps;
    }

    public String getTunnelProfile() {
        return tunnelProfile;
    }

    public Subscriber tunnelProfile(String tunnelProfile) {
        this.tunnelProfile = tunnelProfile;
        return this;
    }

    public void setTunnelProfile(String tunnelProfile) {
        this.tunnelProfile = tunnelProfile;
    }

    public String getUmtServiceData() {
        return umtServiceData;
    }

    public Subscriber umtServiceData(String umtServiceData) {
        this.umtServiceData = umtServiceData;
        return this;
    }

    public void setUmtServiceData(String umtServiceData) {
        this.umtServiceData = umtServiceData;
    }

    public String getUserAuthRequired() {
        return userAuthRequired;
    }

    public Subscriber userAuthRequired(String userAuthRequired) {
        this.userAuthRequired = userAuthRequired;
        return this;
    }

    public void setUserAuthRequired(String userAuthRequired) {
        this.userAuthRequired = userAuthRequired;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subscriber)) {
            return false;
        }
        return id != null && id.equals(((Subscriber) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Subscriber{" +
            "id=" + getId() +
            ", asskeng='" + getAsskeng() + "'" +
            ", calid='" + getCalid() + "'" +
            ", dlgipv6Prefix='" + getDlgipv6Prefix() + "'" +
            ", dlgipv6Prefixlen='" + getDlgipv6Prefixlen() + "'" +
            ", dnsProfile='" + getDnsProfile() + "'" +
            ", errorelement='" + getErrorelement() + "'" +
            ", errormessage='" + getErrormessage() + "'" +
            ", errorvalue='" + getErrorvalue() + "'" +
            ", filterid='" + getFilterid() + "'" +
            ", frmdipv6Prefix='" + getFrmdipv6Prefix() + "'" +
            ", frmdipv6Prefixlen='" + getFrmdipv6Prefixlen() + "'" +
            ", ipaddress='" + getIpaddress() + "'" +
            ", ipnetmask='" + getIpnetmask() + "'" +
            ", ipversion='" + getIpversion() + "'" +
            ", keyid='" + getKeyid() + "'" +
            ", maxDownL3='" + getMaxDownL3() + "'" +
            ", maxSessionDuration='" + getMaxSessionDuration() + "'" +
            ", maxUpL3='" + getMaxUpL3() + "'" +
            ", mfzg='" + getMfzg() + "'" +
            ", msisdn='" + getMsisdn() + "'" +
            ", netprofileid='" + getNetprofileid() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", passwort='" + getPasswort() + "'" +
            ", passwortEnc='" + getPasswortEnc() + "'" +
            ", policyGroup='" + getPolicyGroup() + "'" +
            ", profilset='" + getProfilset() + "'" +
            ", rc='" + getRc() + "'" +
            ", rectime='" + getRectime() + "'" +
            ", requestID='" + getRequestID() + "'" +
            ", reserveprefix='" + getReserveprefix() + "'" +
            ", returnmessage='" + getReturnmessage() + "'" +
            ", rsptime='" + getRsptime() + "'" +
            ", tlnnr='" + getTlnnr() + "'" +
            ", tlnsps='" + getTlnsps() + "'" +
            ", tunnelProfile='" + getTunnelProfile() + "'" +
            ", umtServiceData='" + getUmtServiceData() + "'" +
            ", userAuthRequired='" + getUserAuthRequired() + "'" +
            "}";
    }
}
