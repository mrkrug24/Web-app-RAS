package com.prosphere.ras.models;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NonNull
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    @NonNull
    private String last_name;

    @Column(name = "street")
    @NonNull
    private String street;

    @Column(name = "building")
    @NonNull
    private Integer building;

    @Column(name = "apartment")
    @NonNull
    private Integer apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sought_post", referencedColumnName = "id")
    private Position sought_post;

    @Column(name = "sought_salary")
    private Integer sought_salary;

    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> app_ed;

    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workhistory> app_work;

    public Applicant() {}

    public Applicant(String first_name, String middle_name, String last_name, String street, Integer building,
                    Integer apartment, Position sought_post, Integer sought_salary) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = sought_post;
        this.sought_salary = sought_salary;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    public Applicant(String first_name, String middle_name, String last_name, String street, Integer building, Integer apartment) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = null;
        this.sought_salary = null;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    public Applicant(String first_name, String middle_name, String last_name, String street, Integer building, Integer apartment, Position sought_post) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = sought_post;
        this.sought_salary = null;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    public Applicant(String first_name, String last_name, String street, Integer building,
                    Integer apartment, Position sought_post, Integer sought_salary) {
        this.first_name = first_name;
        this.middle_name = null;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = sought_post;
        this.sought_salary = sought_salary;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    public Applicant(String first_name, String last_name, String street, Integer building, Integer apartment) {
        this.first_name = first_name;
        this.middle_name = null;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = null;
        this.sought_salary = null;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    public Applicant(String first_name, String last_name, String street, Integer building, Integer apartment, Position sought_post) {
        this.first_name = first_name;
        this.middle_name = null;
        this.last_name = last_name;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.sought_post = sought_post;
        this.sought_salary = null;
        this.app_ed = new ArrayList<>();
        this.app_work = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((middle_name == null) ? 0 : middle_name.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((building == null) ? 0 : building.hashCode());
        result = prime * result + ((apartment == null) ? 0 : apartment.hashCode());
        result = prime * result + ((sought_post == null) ? 0 : sought_post.hashCode());
        result = prime * result + ((sought_salary == null) ? 0 : sought_salary.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Applicant other = (Applicant) obj;

        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;

        if (first_name == null) {
            if (other.first_name != null) return false;
        } else if (!first_name.equals(other.first_name)) return false;

        if (middle_name == null) {
            if (other.middle_name != null) return false;
        } else if (!middle_name.equals(other.middle_name)) return false;

        if (last_name == null) {
            if (other.last_name != null) return false;
        } else if (!last_name.equals(other.last_name)) return false;

        if (street == null) {
            if (other.street != null) return false;
        } else if (!street.equals(other.street)) return false;

        if (building == null) {
            if (other.building != null) return false;
        } else if (!building.equals(other.building)) return false;

        if (apartment == null) {
            if (other.apartment != null) return false;
        } else if (!apartment.equals(other.apartment)) return false;

        if (sought_post == null) {
            if (other.sought_post != null) return false;
        } else if (!sought_post.equals(other.sought_post)) return false;

        if (sought_salary == null) {
            if (other.sought_salary != null) return false;
        } else if (!sought_salary.equals(other.sought_salary)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Applicant [id=" + id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
                + last_name + ", street=" + street + ", building=" + building + ", apartment=" + apartment
                + ", sought_post=" + sought_post + ", sought_salary=" + sought_salary + "]";
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public Position getSoughtPost() {
        return sought_post;
    }

    public void setSoughtPost(Position sought_post) {
        this.sought_post = sought_post;
    }

    public Integer getSoughtSalary() {
        return sought_salary;
    }

    public void setSoughtSalary(Integer sought_salary) {
        this.sought_salary = sought_salary;
    }

    public List<Education> getAppEd() {
        return app_ed;
    }

    public void setAppEd(List<Education> app_ed) {
        this.app_ed = app_ed;
    }

    public List<Workhistory> getAppWork() {
        return app_work;
    }

    public void setAppWork(List<Workhistory> app_work) {
        this.app_work = app_work;
    }
}