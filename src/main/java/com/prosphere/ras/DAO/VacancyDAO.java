package com.prosphere.ras.DAO;
import java.util.List;
import com.prosphere.ras.HibernateSessionFactory;
import com.prosphere.ras.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.TypedQuery;

public class VacancyDAO extends CommonOthersDAO<Vacancy> {

    public VacancyDAO() {
        super(Vacancy.class);
    }

    public Vacancy findByObj(Company company, Position position) {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder(
                "SELECT v FROM Vacancy v " +
                "WHERE v.company = :company " +
                "AND v.position = :position ");

            TypedQuery<Vacancy> query = session.createQuery(queryString.toString(), Vacancy.class);
            
            query.setParameter("company", company);
            query.setParameter("position", position);

            Vacancy res = query.getSingleResult();
            t.commit();
            return res;
        } catch (Exception e) {
            System.out.println("findByObj error: " + e);
            t.rollback();
            return null;
        }
    }

    public void deleteByObj(Company company, Position position) {
        Vacancy obj = findByObj(company, position);
        if (obj != null) {
            try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
                Transaction t = session.beginTransaction();
                session.remove(obj);
                t.commit();
            }
        } else {
            System.out.println("deleteByObj error");
        }
    }

    public List<Vacancy> filter(List<Company> company, List<Position> position, Integer minSalary, Integer maxSalary) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT v FROM Vacancy v WHERE 1=1");

            if (company != null && !company.isEmpty()) queryString.append(" AND v.company IN :company");
            if (position != null && !position.isEmpty()) queryString.append(" AND v.position IN :position");
            if (minSalary != null) queryString.append(" AND v.salary >= :minSalary");
            if (maxSalary != null) queryString.append(" AND v.salary <= :maxSalary");

            TypedQuery<Vacancy> query = session.createQuery(queryString.toString(), Vacancy.class);

            if (company != null && !company.isEmpty()) query.setParameter("company", company);
            if (position != null && !position.isEmpty()) query.setParameter("position", position);
            if (minSalary != null) query.setParameter("minSalary", minSalary);
            if (maxSalary != null) query.setParameter("maxSalary", maxSalary);

            List<Vacancy> res = query.getResultList();
            t.commit();

            return res;
        }
    }

    public List<Applicant> findSuitableResumes(Vacancy obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT a FROM Applicant a ");
    
            queryString.append(" WHERE a.sought_post = :position");
            if (obj.getSalary() != null) queryString.append(" AND (a.sought_salary IS NULL OR a.sought_salary <= :salary)");
            if (obj.getReqSpec() != null) queryString.append(" AND EXISTS (SELECT 1 FROM Education ed WHERE ed.applicant = a AND ed.speciality = :speciality) ");
    
            if (obj.getReqExp() != null) {
                queryString.append(" AND EXISTS ");
                queryString.append("(SELECT 1 FROM (SELECT SUM(CASE WHEN wh.end_date IS NULL THEN CURRENT_DATE - wh.start_date ELSE wh.end_date - wh.start_date END) / 365 AS totalExperience ");
                queryString.append("FROM Workhistory wh WHERE wh.applicant = a AND wh.position = :position GROUP BY wh.applicant) AS TotalExperience ");
                queryString.append("WHERE TotalExperience.totalExperience >= :experience)");
            }
    
            TypedQuery<Applicant> query = session.createQuery(queryString.toString(), Applicant.class);
    
            query.setParameter("position", obj.getPosition());
            if (obj.getSalary() != null) query.setParameter("salary", obj.getSalary());
            if (obj.getReqSpec() != null) query.setParameter("speciality", obj.getReqSpec());
            if (obj.getReqExp() != null) query.setParameter("experience", obj.getReqExp());
    
            List<Applicant> res = query.getResultList();
            t.commit();
    
            return res;
        }
    }
}