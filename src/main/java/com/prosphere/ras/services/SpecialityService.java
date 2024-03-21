package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import com.prosphere.ras.DAO.SpecialityDAO;

public class SpecialityService extends CommonService<Speciality, SpecialityDAO> {
    public SpecialityService(){
        super(new SpecialityDAO());
    }
}