package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import java.util.List;
import com.prosphere.ras.DAO.ApplicantDAO;

public class ApplicantService extends CommonService<Applicant, ApplicantDAO> {
    public ApplicantService(){
        super(new ApplicantDAO());
    }

    public List<Applicant> filter(List<Speciality> speciality, List<Company> company, List<Position> position, Integer minSalary, Integer maxSalary) {
        return dao.filter(speciality, company, position, minSalary, maxSalary);
    }

    public List<Workhistory> findWorkhistory(Applicant obj) {
        return dao.findWorkhistory(obj);
    }

    public List<Education> findEducation(Applicant obj) {
        return dao.findEducation(obj);
    }

    public List<Vacancy> findSuitableVacancy(Applicant obj) {
        return dao.findSuitableVacancy(obj);
    }
}