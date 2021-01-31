package com.dtit.tm.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A IpCredentails.
 */
@Entity
@Table(name = "ip_credentails")
public class IpCredentails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_nr")
    private String toNr;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToNr() {
        return toNr;
    }

    public IpCredentails toNr(String toNr) {
        this.toNr = toNr;
        return this;
    }

    public void setToNr(String toNr) {
        this.toNr = toNr;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IpCredentails)) {
            return false;
        }
        return id != null && id.equals(((IpCredentails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IpCredentails{" +
            "id=" + getId() +
            ", toNr='" + getToNr() + "'" +
            "}";
    }
}
