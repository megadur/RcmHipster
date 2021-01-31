package com.dtit.tm.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dtit.tm.domain.Credentials} entity.
 */
public class CredentialsDTO implements Serializable {
    
    private Long id;

    private String tonr;

    private String ask;

    private String password;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTonr() {
        return tonr;
    }

    public void setTonr(String tonr) {
        this.tonr = tonr;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CredentialsDTO)) {
            return false;
        }

        return id != null && id.equals(((CredentialsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CredentialsDTO{" +
            "id=" + getId() +
            ", tonr='" + getTonr() + "'" +
            ", ask='" + getAsk() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
