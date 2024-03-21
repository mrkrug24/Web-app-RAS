package com.prosphere.ras.services;
import com.prosphere.ras.models.*;
import com.prosphere.ras.DAO.WorkhistoryDAO;

public class WorkhistoryService extends CommonOthersService<Workhistory, WorkhistoryDAO> {
    public WorkhistoryService(){
        super(new WorkhistoryDAO());
    }

    public Workhistory findByObj(Applicant applicant, Company company, Position position) {
        return dao.findByObj(applicant, company, position);
    }

    public void deleteByObj(Applicant applicant, Company company, Position position) {
        dao.deleteByObj(applicant, company, position);
    }
}