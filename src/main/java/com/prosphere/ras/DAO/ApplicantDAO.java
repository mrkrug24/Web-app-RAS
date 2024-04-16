package com.prosphere.ras.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import com.prosphere.ras.models.*;
import com.prosphere.ras.util.HibernateSessionFactory;

import jakarta.persistence.TypedQuery;

public class ApplicantDAO extends CommonDAO<Applicant> {

    public ApplicantDAO() {
        super(Applicant.class);
    }

    public List<Workhistory> findWorkhistory(Applicant obj) {
        return obj.getAppWork();
    }

    public List<Education> findEducation(Applicant obj) {
        return obj.getAppEd();
    }

    public List<Applicant> filter(Integer specialityId, Integer companyId, Integer positionId, Integer minSalary, Integer maxSalary) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT DISTINCT a FROM Applicant a");
    
            if (positionId != null || companyId != null || minSalary != null || maxSalary != null) {
                queryString.append(" LEFT JOIN a.app_work aw");
            }
    
            if (specialityId != null) {
                queryString.append(" LEFT JOIN a.app_ed ae");
            }
    
            queryString.append(" WHERE 1=1");
    
            if (specialityId != null) queryString.append(" AND ae.speciality.id = :specialityId");
            if (companyId != null) queryString.append(" AND aw.company.id = :companyId");
            if (positionId != null) queryString.append(" AND a.sought_post.id = :positionId");
            if (minSalary != null) queryString.append(" AND a.sought_salary >= :minSalary");
            if (maxSalary != null) queryString.append(" AND a.sought_salary <= :maxSalary");
    
            TypedQuery<Applicant> query = session.createQuery(queryString.toString(), Applicant.class);
    
            if (specialityId != null) query.setParameter("specialityId", specialityId);
            if (companyId != null) query.setParameter("companyId", companyId);
            if (positionId != null) query.setParameter("positionId", positionId);
            if (minSalary != null) query.setParameter("minSalary", minSalary);
            if (maxSalary != null) query.setParameter("maxSalary", maxSalary);
    
            List<Applicant> res = query.getResultList();
            t.commit();
    
            return res;
        } 
    }

    public List<Vacancy> findSuitableVacancy(Applicant obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT v FROM Vacancy v ");
            queryString.append("WHERE v.position.id = :sought_postId ");
            if (obj.getSoughtSalary() != null) queryString.append("AND v.salary >= :sought_salary ");
            queryString.append("AND (v.req_spec IS NULL OR v.req_spec.id IN :speciality) ");
            queryString.append("AND (v.req_exp IS NULL OR (SELECT SUM(CASE WHEN wh.end_date IS NULL THEN TIMESTAMPDIFF(DAY, wh.start_date, CURRENT_DATE) ELSE TIMESTAMPDIFF(DAY, wh.start_date, wh.end_date) END) / 365.0 ");
            queryString.append("FROM Workhistory wh WHERE wh.applicant.id = :applicant AND wh.position.id = :position) >= v.req_exp) ");

            TypedQuery<Vacancy> query = session.createQuery(queryString.toString(), Vacancy.class);
            
            query.setParameter("sought_postId", obj.getSoughtPost().getId());
            if (obj.getSoughtSalary() != null) query.setParameter("sought_salary", obj.getSoughtSalary());
            List<Integer> speciality = new ArrayList<>();
            for (Education education : obj.getAppEd()) speciality.add(education.getSpeciality().getId());
            query.setParameter("speciality", speciality);
            query.setParameter("applicant", obj.getId());
            query.setParameter("position", obj.getSoughtPost().getId());

            List<Vacancy> res = query.getResultList();
            t.commit();
            
            return res;
        }
    }
}