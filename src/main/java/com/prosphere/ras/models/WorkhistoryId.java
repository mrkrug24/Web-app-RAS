package com.prosphere.ras.models;
import java.io.Serializable;
import lombok.*;

public class WorkhistoryId implements Serializable {
    @NonNull
    private Applicant applicant;

    @NonNull
    private Company company;

    @NonNull
    private Position position;

    public WorkhistoryId() {}

    public WorkhistoryId(Applicant applicant, Company company, Position position) {
        this.applicant = applicant;
        this.company = company;
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        WorkhistoryId other = (WorkhistoryId) obj;

        if (applicant == null) {
            if (other.applicant != null) return false;
        } else if (!applicant.equals(other.applicant)) return false;

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
        return "WorkhistoryId [applicant=" + applicant + ", company=" + company + ", position=" + position + "]";
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}