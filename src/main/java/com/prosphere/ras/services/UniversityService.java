package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import com.prosphere.ras.DAO.UniversityDAO;

public class UniversityService extends CommonService<University, UniversityDAO> {
    public UniversityService(){
        super(new UniversityDAO());
    }
}