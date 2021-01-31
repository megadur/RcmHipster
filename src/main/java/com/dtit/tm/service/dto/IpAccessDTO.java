package com.dtit.tm.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dtit.tm.domain.IpAccess} entity.
 */
public class IpAccessDTO implements Serializable {
    
    private Long id;

    private String anschlussbilanzierung;

    private String bssoeorderid;

    private String dnsprofile;

    private String filterid;

    private String fonAktiv;

    private String ipversion;

    private String lineid;

    private String maxdownspeed;

    private String maxsessionduration;

    private String maxupspeed;

    private String mehrfachzugang;

    private String profileid;

    private String rechtAufFesteIpadresse;

    private String toNr;

    private String umtServiceDataOcssubscriptionid;

    private String umtServiceDataThrottledownl3;

    private String umtServiceDataThrottleprofile;

    private String umtServiceDataThrottleupl3;

    private String usecase;

    private String userauthenticationrequired;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnschlussbilanzierung() {
        return anschlussbilanzierung;
    }

    public void setAnschlussbilanzierung(String anschlussbilanzierung) {
        this.anschlussbilanzierung = anschlussbilanzierung;
    }

    public String getBssoeorderid() {
        return bssoeorderid;
    }

    public void setBssoeorderid(String bssoeorderid) {
        this.bssoeorderid = bssoeorderid;
    }

    public String getDnsprofile() {
        return dnsprofile;
    }

    public void setDnsprofile(String dnsprofile) {
        this.dnsprofile = dnsprofile;
    }

    public String getFilterid() {
        return filterid;
    }

    public void setFilterid(String filterid) {
        this.filterid = filterid;
    }

    public String getFonAktiv() {
        return fonAktiv;
    }

    public void setFonAktiv(String fonAktiv) {
        this.fonAktiv = fonAktiv;
    }

    public String getIpversion() {
        return ipversion;
    }

    public void setIpversion(String ipversion) {
        this.ipversion = ipversion;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getMaxdownspeed() {
        return maxdownspeed;
    }

    public void setMaxdownspeed(String maxdownspeed) {
        this.maxdownspeed = maxdownspeed;
    }

    public String getMaxsessionduration() {
        return maxsessionduration;
    }

    public void setMaxsessionduration(String maxsessionduration) {
        this.maxsessionduration = maxsessionduration;
    }

    public String getMaxupspeed() {
        return maxupspeed;
    }

    public void setMaxupspeed(String maxupspeed) {
        this.maxupspeed = maxupspeed;
    }

    public String getMehrfachzugang() {
        return mehrfachzugang;
    }

    public void setMehrfachzugang(String mehrfachzugang) {
        this.mehrfachzugang = mehrfachzugang;
    }

    public String getProfileid() {
        return profileid;
    }

    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    public String getRechtAufFesteIpadresse() {
        return rechtAufFesteIpadresse;
    }

    public void setRechtAufFesteIpadresse(String rechtAufFesteIpadresse) {
        this.rechtAufFesteIpadresse = rechtAufFesteIpadresse;
    }

    public String getToNr() {
        return toNr;
    }

    public void setToNr(String toNr) {
        this.toNr = toNr;
    }

    public String getUmtServiceDataOcssubscriptionid() {
        return umtServiceDataOcssubscriptionid;
    }

    public void setUmtServiceDataOcssubscriptionid(String umtServiceDataOcssubscriptionid) {
        this.umtServiceDataOcssubscriptionid = umtServiceDataOcssubscriptionid;
    }

    public String getUmtServiceDataThrottledownl3() {
        return umtServiceDataThrottledownl3;
    }

    public void setUmtServiceDataThrottledownl3(String umtServiceDataThrottledownl3) {
        this.umtServiceDataThrottledownl3 = umtServiceDataThrottledownl3;
    }

    public String getUmtServiceDataThrottleprofile() {
        return umtServiceDataThrottleprofile;
    }

    public void setUmtServiceDataThrottleprofile(String umtServiceDataThrottleprofile) {
        this.umtServiceDataThrottleprofile = umtServiceDataThrottleprofile;
    }

    public String getUmtServiceDataThrottleupl3() {
        return umtServiceDataThrottleupl3;
    }

    public void setUmtServiceDataThrottleupl3(String umtServiceDataThrottleupl3) {
        this.umtServiceDataThrottleupl3 = umtServiceDataThrottleupl3;
    }

    public String getUsecase() {
        return usecase;
    }

    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }

    public String getUserauthenticationrequired() {
        return userauthenticationrequired;
    }

    public void setUserauthenticationrequired(String userauthenticationrequired) {
        this.userauthenticationrequired = userauthenticationrequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IpAccessDTO)) {
            return false;
        }

        return id != null && id.equals(((IpAccessDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IpAccessDTO{" +
            "id=" + getId() +
            ", anschlussbilanzierung='" + getAnschlussbilanzierung() + "'" +
            ", bssoeorderid='" + getBssoeorderid() + "'" +
            ", dnsprofile='" + getDnsprofile() + "'" +
            ", filterid='" + getFilterid() + "'" +
            ", fonAktiv='" + getFonAktiv() + "'" +
            ", ipversion='" + getIpversion() + "'" +
            ", lineid='" + getLineid() + "'" +
            ", maxdownspeed='" + getMaxdownspeed() + "'" +
            ", maxsessionduration='" + getMaxsessionduration() + "'" +
            ", maxupspeed='" + getMaxupspeed() + "'" +
            ", mehrfachzugang='" + getMehrfachzugang() + "'" +
            ", profileid='" + getProfileid() + "'" +
            ", rechtAufFesteIpadresse='" + getRechtAufFesteIpadresse() + "'" +
            ", toNr='" + getToNr() + "'" +
            ", umtServiceDataOcssubscriptionid='" + getUmtServiceDataOcssubscriptionid() + "'" +
            ", umtServiceDataThrottledownl3='" + getUmtServiceDataThrottledownl3() + "'" +
            ", umtServiceDataThrottleprofile='" + getUmtServiceDataThrottleprofile() + "'" +
            ", umtServiceDataThrottleupl3='" + getUmtServiceDataThrottleupl3() + "'" +
            ", usecase='" + getUsecase() + "'" +
            ", userauthenticationrequired='" + getUserauthenticationrequired() + "'" +
            "}";
    }
}
