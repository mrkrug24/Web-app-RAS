package com.prosphere.ras.services;
import com.prosphere.ras.models.*;

import java.util.List;

import com.prosphere.ras.DAO.CompanyDAO;

public class CompanyService extends CommonService<Company, CompanyDAO> {
    public CompanyService(){
        super(new CompanyDAO());
    }

    public List<Vacancy> findVacancy(Company obj) {
        return dao.findVacancy(obj);
    }
}