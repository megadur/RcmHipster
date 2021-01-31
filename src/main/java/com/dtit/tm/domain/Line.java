package com.dtit.tm.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Line.
 */
@Entity
@Table(name = "line")
public class Line implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uar")
    private Boolean uar;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isUar() {
        return uar;
    }

    public Line uar(Boolean uar) {
        this.uar = uar;
        return this;
    }

    public void setUar(Boolean uar) {
        this.uar = uar;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        return id != null && id.equals(((Line) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Line{" +
            "id=" + getId() +
            ", uar='" + isUar() + "'" +
            "}";
    }
}
