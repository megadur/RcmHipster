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

    @Column(name = "dnsprofile")
    private String dnsprofile;

    @Column(name = "filterid")
    private String filterid;

    @Column(name = "fon_aktiv")
    private String fonAktiv;

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

    @Column(name = "recht_auf_feste_ipadresse")
    private String rechtAufFesteIpadresse;

    @Column(name = "to_nr")
    private String toNr;

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
