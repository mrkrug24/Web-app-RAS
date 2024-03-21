package com.prosphere.ras.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import com.prosphere.ras.HibernateSessionFactory;
import com.prosphere.ras.models.*;
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

    public List<Applicant> filter(List<Speciality> speciality, List<Company> company, List<Position> position, Integer minSalary, Integer maxSalary) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            StringBuilder queryString = new StringBuilder("SELECT DISTINCT a FROM Applicant a");
            if ((company != null && !company.isEmpty()) ||
                (position != null && !position.isEmpty()) ||
                (minSalary != null) ||
                (maxSalary != null)) {
                queryString.append(" LEFT JOIN a.app_work aw");
            }

            if (speciality != null && !speciality.isEmpty()) {
                queryString.append(" LEFT JOIN a.app_ed ae");
            }

            queryString.append(" WHERE 1=1");

            if (speciality != null && !speciality.isEmpty()) queryString.append(" AND ae.speciality IN :speciality");
            if (company != null && !company.isEmpty()) queryString.append(" AND aw.company IN :company");
            if (position != null && !position.isEmpty()) queryString.append(" AND aw.position IN :position");
            if (minSalary != null) queryString.append(" AND aw.salary >= :minSalary");
            if (maxSalary != null) queryString.append(" AND aw.salary <= :maxSalary");

            TypedQuery<Applicant> query = session.createQuery(queryString.toString(), Applicant.class);

            if (speciality != null && !speciality.isEmpty()) query.setParameter("speciality", speciality);
            if (company != null && !company.isEmpty()) query.setParameter("company", company);
            if (position != null && !position.isEmpty()) query.setParameter("position", position);
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
            queryString.append("WHERE v.position = :sought_post ");
            if (obj.getSoughtSalary() != null) queryString.append("AND v.salary >= :sought_salary ");
            queryString.append("AND (v.req_spec IS NULL OR v.req_spec IN :speciality) ");
            queryString.append("AND (v.req_exp IS NULL OR (SELECT SUM(CASE WHEN wh.end_date IS NULL THEN CURRENT_DATE - wh.start_date ELSE wh.end_date - wh.start_date END) / 365 ");
            queryString.append("FROM Workhistory wh WHERE wh.applicant = :applicant AND wh.position = :position) <= v.req_exp)");

            TypedQuery<Vacancy> query = session.createQuery(queryString.toString(), Vacancy.class);
            
            query.setParameter("sought_post", obj.getSoughtPost());
            if (obj.getSoughtSalary() != null) query.setParameter("sought_salary", obj.getSoughtSalary());
            List<Speciality> speciality = new ArrayList<>();
            for (Education education : obj.getAppEd()) speciality.add(education.getSpeciality());
            query.setParameter("speciality", speciality);
            query.setParameter("applicant", obj);
            query.setParameter("position", obj.getSoughtPost());

            List<Vacancy> res = query.getResultList();
            t.commit();
            
            return res;
        }
    }
}