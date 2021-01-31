package com.dtit.tm.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.dtit.tm.domain.Line} entity.
 */
public class LineDTO implements Serializable {
    
    private Long id;

    private Boolean uar;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isUar() {
        return uar;
    }

    public void setUar(Boolean uar) {
        this.uar = uar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LineDTO)) {
            return false;
        }

        return id != null && id.equals(((LineDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LineDTO{" +
            "id=" + getId() +
            ", uar='" + isUar() + "'" +
            "}";
    }
}
