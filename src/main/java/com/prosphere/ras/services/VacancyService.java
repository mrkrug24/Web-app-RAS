package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import java.util.List;
import com.prosphere.ras.DAO.VacancyDAO;

public class VacancyService extends CommonOthersService<Vacancy, VacancyDAO> {
    public VacancyService(){
        super(new VacancyDAO());
    }

    public Vacancy findByObj(Integer company, Integer position) {
        return dao.findByObj(company, position);
    }

    public void deleteByObj(Integer company, Integer position) {
        dao.deleteByObj(company, position);
    }

    public List<Vacancy> filter(Integer company, Integer position, Integer minSalary, Integer maxSalary) {
        return dao.filter(company, position, minSalary, maxSalary);
    }

    public List<Applicant> findSuitableResumes(Vacancy obj) {
        return dao.findSuitableResumes(obj);
    }
}