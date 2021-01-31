package com.dtit.tm.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dtit.tm.domain.Subscriber} entity.
 */
public class SubscriberDTO implements Serializable {
    
    private Long id;

    private String asskeng;

    private String calid;

    private String dnsProfile;

    private String errorelement;

    private String errormessage;

    private String errorvalue;

    private String ipversion;

    private String keyid;

    private String maxDownL3;

    private String maxSessionDuration;

    private String maxUpL3;

    private String mfzg;

    private String netprofileid;

    private String origin;

    private String passwort;

    private String passwortEnc;

    private String policyGroup;

    private String profilset;

    private String rc;

    private String rectime;

    private String requestID;

    private String returnmessage;

    private String rsptime;

    private String tlnnr;

    private String tlnsps;

    private String userAuthRequired;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsskeng() {
        return asskeng;
    }

    public void setAsskeng(String asskeng) {
        this.asskeng = asskeng;
    }

    public String getCalid() {
        return calid;
    }

    public void setCalid(String calid) {
        this.calid = calid;
    }

    public String getDnsProfile() {
        return dnsProfile;
    }

    public void setDnsProfile(String dnsProfile) {
        this.dnsProfile = dnsProfile;
    }

    public String getErrorelement() {
        return errorelement;
    }

    public void setErrorelement(String errorelement) {
        this.errorelement = errorelement;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrorvalue() {
        return errorvalue;
    }

    public void setErrorvalue(String errorvalue) {
        this.errorvalue = errorvalue;
    }

    public String getIpversion() {
        return ipversion;
    }

    public void setIpversion(String ipversion) {
        this.ipversion = ipversion;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getMaxDownL3() {
        return maxDownL3;
    }

    public void setMaxDownL3(String maxDownL3) {
        this.maxDownL3 = maxDownL3;
    }

    public String getMaxSessionDuration() {
        return maxSessionDuration;
    }

    public void setMaxSessionDuration(String maxSessionDuration) {
        this.maxSessionDuration = maxSessionDuration;
    }

    public String getMaxUpL3() {
        return maxUpL3;
    }

    public void setMaxUpL3(String maxUpL3) {
        this.maxUpL3 = maxUpL3;
    }

    public String getMfzg() {
        return mfzg;
    }

    public void setMfzg(String mfzg) {
        this.mfzg = mfzg;
    }

    public String getNetprofileid() {
        return netprofileid;
    }

    public void setNetprofileid(String netprofileid) {
        this.netprofileid = netprofileid;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getPasswortEnc() {
        return passwortEnc;
    }

    public void setPasswortEnc(String passwortEnc) {
        this.passwortEnc = passwortEnc;
    }

    public String getPolicyGroup() {
        return policyGroup;
    }

    public void setPolicyGroup(String policyGroup) {
        this.policyGroup = policyGroup;
    }

    public String getProfilset() {
        return profilset;
    }

    public void setProfilset(String profilset) {
        this.profilset = profilset;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRectime() {
        return rectime;
    }

    public void setRectime(String rectime) {
        this.rectime = rectime;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getReturnmessage() {
        return returnmessage;
    }

    public void setReturnmessage(String returnmessage) {
        this.returnmessage = returnmessage;
    }

    public String getRsptime() {
        return rsptime;
    }

    public void setRsptime(String rsptime) {
        this.rsptime = rsptime;
    }

    public String getTlnnr() {
        return tlnnr;
    }

    public void setTlnnr(String tlnnr) {
        this.tlnnr = tlnnr;
    }

    public String getTlnsps() {
        return tlnsps;
    }

    public void setTlnsps(String tlnsps) {
        this.tlnsps = tlnsps;
    }

    public String getUserAuthRequired() {
        return userAuthRequired;
    }

    public void setUserAuthRequired(String userAuthRequired) {
        this.userAuthRequired = userAuthRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubscriberDTO)) {
            return false;
        }

        return id != null && id.equals(((SubscriberDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SubscriberDTO{" +
            "id=" + getId() +
            ", asskeng='" + getAsskeng() + "'" +
            ", calid='" + getCalid() + "'" +
            ", dnsProfile='" + getDnsProfile() + "'" +
            ", errorelement='" + getErrorelement() + "'" +
            ", errormessage='" + getErrormessage() + "'" +
            ", errorvalue='" + getErrorvalue() + "'" +
            ", ipversion='" + getIpversion() + "'" +
            ", keyid='" + getKeyid() + "'" +
            ", maxDownL3='" + getMaxDownL3() + "'" +
            ", maxSessionDuration='" + getMaxSessionDuration() + "'" +
            ", maxUpL3='" + getMaxUpL3() + "'" +
            ", mfzg='" + getMfzg() + "'" +
            ", netprofileid='" + getNetprofileid() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", passwort='" + getPasswort() + "'" +
            ", passwortEnc='" + getPasswortEnc() + "'" +
            ", policyGroup='" + getPolicyGroup() + "'" +
            ", profilset='" + getProfilset() + "'" +
            ", rc='" + getRc() + "'" +
            ", rectime='" + getRectime() + "'" +
            ", requestID='" + getRequestID() + "'" +
            ", returnmessage='" + getReturnmessage() + "'" +
            ", rsptime='" + getRsptime() + "'" +
            ", tlnnr='" + getTlnnr() + "'" +
            ", tlnsps='" + getTlnsps() + "'" +
            ", userAuthRequired='" + getUserAuthRequired() + "'" +
            "}";
    }
}
