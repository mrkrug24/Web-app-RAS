package com.prosphere.ras.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.prosphere.ras.models.*;
import jakarta.persistence.TypedQuery;
import com.prosphere.ras.util.HibernateSessionFactory;

public class EducationDAO extends CommonOthersDAO<Education> {
    public EducationDAO(){
        super(Education.class);
    }

    public Education findByObj(Applicant applicant, University university, Speciality speciality) {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder(
                "SELECT e FROM Education e " +
                "WHERE e.applicant = :applicant " +
                "AND e.university = :university " +
                "AND e.speciality = :speciality");

            TypedQuery<Education> query = session.createQuery(queryString.toString(), Education.class);
            
            query.setParameter("applicant", applicant);
            query.setParameter("university", university);
            query.setParameter("speciality", speciality);

            Education res = query.getSingleResult();
            t.commit();
            return res;
        } catch (Exception e) {
            System.out.println("findByObj error: " + e);
            t.rollback();
            return null;
        }
    }

    public void deleteByObj(Applicant applicant, University university, Speciality speciality) {
        Education obj = findByObj(applicant, university, speciality);
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
}