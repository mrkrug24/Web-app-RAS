package com.prosphere.ras.services;
import com.prosphere.ras.models.*;

import java.util.List;

import com.prosphere.ras.DAO.CompanyDAO;

public class CompanyService extends CommonService<Company, CompanyDAO> {
    public CompanyService(){
        super(new CompanyDAO());
    }

    public Company findByName(String name) {
        return dao.findByName(name);
    }

    public List<Position> findNewPositions(Company company) {
        return dao.findNewPositions(company);
    }

    public List<Vacancy> findVacancy(Company obj) {
        return dao.findVacancy(obj);
    }
}