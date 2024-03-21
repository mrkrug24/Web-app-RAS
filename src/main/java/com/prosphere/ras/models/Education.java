package com.prosphere.ras.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "education")
@IdClass(EducationId.class)
public class Education {
    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    @NonNull
    private Applicant applicant;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @NonNull
    private University university;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    @NonNull
    private Speciality speciality;

    public Education() {}

    public Education(Applicant applicant, University university, Speciality speciality) {
        this.applicant = applicant;
        this.university = university;
        this.speciality = speciality;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
        result = prime * result + ((university == null) ? 0 : university.hashCode());
        result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Education other = (Education) obj;

        if (applicant == null) {
            if (other.applicant != null) return false;
        } else if (!applicant.equals(other.applicant)) return false;

        if (university == null) {
            if (other.university != null) return false;
        } else if (!university.equals(other.university)) return false;

        if (speciality == null) {
            if (other.speciality != null) return false;
        } else if (!speciality.equals(other.speciality)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Education [applicant=" + applicant + ", university=" + university + ", speciality=" + speciality + "]";
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}