package com.prosphere.ras.models;
import java.io.Serializable;
import lombok.*;

public class VacancyId implements Serializable {
    @NonNull
    private Company company;

    @NonNull
    private Position position;

    public VacancyId() {}

    public VacancyId(Company company, Position position) {
        this.company = company;
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        VacancyId other = (VacancyId) obj;

        if (company == null) {
            if (other.company != null) return false;
        } else if (!company.equals(other.company)) return false;

        if (position == null) {
            if (other.position != null) return false;
        } else if (!position.equals(other.position)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "VacancyId [company=" + company + ", position=" + position + "]";
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany_id(Company company) {
        this.company = company;
    }

    public Position getPosition_id() {
        return position;
    }

    public void setPosition_id(Position position) {
        this.position = position;
    }
}