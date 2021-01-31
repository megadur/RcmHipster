package com.dtit.tm.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Credentials.
 */
@Entity
@Table(name = "credentials")
public class Credentials implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tonr")
    private String tonr;

    @Column(name = "ask")
    private String ask;

    @Column(name = "password")
    private String password;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTonr() {
        return tonr;
    }

    public Credentials tonr(String tonr) {
        this.tonr = tonr;
        return this;
    }

    public void setTonr(String tonr) {
        this.tonr = tonr;
    }

    public String getAsk() {
        return ask;
    }

    public Credentials ask(String ask) {
        this.ask = ask;
        return this;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getPassword() {
        return password;
    }

    public Credentials password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Credentials)) {
            return false;
        }
        return id != null && id.equals(((Credentials) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Credentials{" +
            "id=" + getId() +
            ", tonr='" + getTonr() + "'" +
            ", ask='" + getAsk() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
