package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import java.util.List;
import com.prosphere.ras.DAO.ApplicantDAO;

public class ApplicantService extends CommonService<Applicant, ApplicantDAO> {
    public ApplicantService(){
        super(new ApplicantDAO());
    }

    public List<Applicant> filter(Integer specialityId, Integer companyId, Integer positionId, Integer minSalary, Integer maxSalary) {
        return dao.filter(specialityId, companyId, positionId, minSalary, maxSalary);
    }

    public List<Workhistory> findWorkhistory(Applicant obj) {
        return dao.findWorkhistory(obj);
    }

    public List<Education> findEducation(Applicant obj) {
        return dao.findEducation(obj);
    }

    // public Integer getTotalExperience(int applicantId, int positionId) {
    //     return dao.getTotalExperience(applicantId, positionId);
    // }

    public List<Vacancy> findSuitableVacancy(Applicant obj) {
        return dao.findSuitableVacancy(obj);
    }
}