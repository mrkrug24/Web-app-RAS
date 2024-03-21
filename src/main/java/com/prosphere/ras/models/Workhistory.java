package com.prosphere.ras.models;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workhistory")
@IdClass(WorkhistoryId.class)
public class Workhistory {
    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    @NonNull
    private Applicant applicant;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @NonNull
    private Company company;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @NonNull
    private Position position;

    @Column(name = "salary")
    @NonNull
    private Integer salary;

    @Column(name = "start_date")
    @NonNull
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    public Workhistory() {}
    
    public Workhistory(Applicant applicant, Company company, Position position, Integer salary, LocalDate start_date, LocalDate end_date) {
        this.applicant = applicant;
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Workhistory(Applicant applicant, Company company, Position position, Integer salary, LocalDate start_date) {
        this.applicant = applicant;
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.start_date = start_date;
        this.end_date = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
        result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Workhistory other = (Workhistory) obj;
        if (applicant == null) {
            if (other.applicant != null) return false;
        } else if (!applicant.equals(other.applicant)) return false;

        if (company == null) {
            if (other.company != null) return false;
        } else if (!company.equals(other.company)) return false;

        if (position == null) {
            if (other.position != null) return false;
        } else if (!position.equals(other.position)) return false;

        if (salary == null) {
            if (other.salary != null) return false;
        } else if (!salary.equals(other.salary)) return false;

        if (start_date == null) {
            if (other.start_date != null) return false;
        } else if (!start_date.equals(other.start_date)) return false;

        if (end_date == null) {
            if (other.end_date != null) return false;
        } else if (!end_date.equals(other.end_date)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Workhistory [applicant=" + applicant + ", company=" + company + ", position=" + position + ", salary="
                + salary + ", start_date=" + start_date + ", end_date=" + end_date + "]";
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public void setEndDate(LocalDate end_date) {
        this.end_date = end_date;
    }
}