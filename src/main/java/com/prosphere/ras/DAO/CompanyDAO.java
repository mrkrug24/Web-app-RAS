package com.prosphere.ras.DAO;
import java.util.List;

import com.prosphere.ras.models.*;

public class CompanyDAO extends CommonDAO<Company> {
    public CompanyDAO(){
        super(Company.class);
    }

    public List<Vacancy> findVacancy(Company obj) {
        return obj.getCompVac();
    }
}