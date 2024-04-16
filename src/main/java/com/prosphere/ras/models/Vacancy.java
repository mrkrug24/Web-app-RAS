package com.prosphere.ras.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vacancy")
@IdClass(VacancyId.class)
public class Vacancy {
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
    private Integer salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "req_spec", referencedColumnName = "id")
    private Speciality req_spec;

    @Column(name = "req_exp")
    private Integer req_exp;

    public Vacancy() {}

    public Vacancy(Company company, Position position, Integer salary, Speciality req_spec, Integer req_exp) {
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.req_spec = req_spec;
        this.req_exp = req_exp;
    }

    public Vacancy(Company company, Position position, Integer salary, Integer req_exp) {
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.req_spec = null;
        this.req_exp = req_exp;
    }

    public Vacancy(Company company, Position position, Integer salary, Speciality req_spec) {
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.req_spec = req_spec;
        this.req_exp = null;
    }

    public Vacancy(Company company, Position position, Integer salary) {
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.req_spec = null;
        this.req_exp = null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((req_spec == null) ? 0 : req_spec.hashCode());
        result = prime * result + ((req_exp == null) ? 0 : req_exp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Vacancy other = (Vacancy) obj;
        if (company == null) {
            if (other.company != null) return false;
        } else if (!company.equals(other.company)) return false;

        if (position == null) {
            if (other.position != null) return false;
        } else if (!position.equals(other.position)) return false;

        if (salary == null) {
            if (other.salary != null) return false;
        } else if (!salary.equals(other.salary)) return false;

        if (req_spec == null) {
            if (other.req_spec != null) return false;
        } else if (!req_spec.equals(other.req_spec)) return false;

        if (req_exp == null) {
            if (other.req_exp != null) return false;
        } else if (!req_exp.equals(other.req_exp)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Vacancy [company=" + company + ", position=" + position + ", salary=" + salary + ", req_spec="
                + req_spec + ", req_exp=" + req_exp + "]";
    }

    public Company getCompany() {
        return company;
    }

    public void setCompanyId(Company company) {
        this.company = company;
    }

    public Position getPosition() {
        return position;
    }

    public void setPositionId(Position position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Speciality getReqSpec() {
        return req_spec;
    }

    public void setReqSpec(Speciality req_spec) {
        this.req_spec = req_spec;
    }

    public Integer getReqExp() {
        return req_exp;
    }

    public void setReqExp(Integer req_exp) {
        this.req_exp = req_exp;
    }
}