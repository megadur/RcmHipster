package com.dtit.tm.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dtit.tm.domain.IpCredentails} entity.
 */
public class IpCredentailsDTO implements Serializable {
    
    private Long id;

    private String toNr;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToNr() {
        return toNr;
    }

    public void setToNr(String toNr) {
        this.toNr = toNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IpCredentailsDTO)) {
            return false;
        }

        return id != null && id.equals(((IpCredentailsDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IpCredentailsDTO{" +
            "id=" + getId() +
            ", toNr='" + getToNr() + "'" +
            "}";
    }
}
