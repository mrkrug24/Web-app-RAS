package com.prosphere.ras.services;
import com.prosphere.ras.models.*;

import com.prosphere.ras.DAO.EducationDAO;

public class EducationService extends CommonOthersService<Education, EducationDAO> {
    public EducationService(){
        super(new EducationDAO());
    }

    public Education findByObj(Applicant applicant, University university, Speciality speciality) {
        return dao.findByObj(applicant, university, speciality);
    }

    public void deleteByObj(Applicant applicant, University university, Speciality speciality) {
        dao.deleteByObj(applicant, university, speciality);
    }
}