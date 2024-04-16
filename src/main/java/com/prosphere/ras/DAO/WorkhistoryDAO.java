package com.prosphere.ras.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.prosphere.ras.models.*;
import jakarta.persistence.TypedQuery;
import com.prosphere.ras.util.HibernateSessionFactory;

public class WorkhistoryDAO extends CommonOthersDAO<Workhistory> {
    public WorkhistoryDAO() {
        super(Workhistory.class);
    }

    public Workhistory findByObj(Applicant applicant, Company company, Position position) {
        Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            StringBuilder queryString = new StringBuilder(
                "SELECT wh FROM Workhistory wh " +
                "WHERE wh.applicant = :applicant " +
                "AND wh.company = :company " +
                "AND wh.position = :position ");

            TypedQuery<Workhistory> query = session.createQuery(queryString.toString(), Workhistory.class);
            
            query.setParameter("applicant", applicant);
            query.setParameter("company", company);
            query.setParameter("position", position);

            Workhistory res = query.getSingleResult();
            t.commit();
            return res;
        } catch (Exception e) {
            System.out.println("findByObj error: " + e);
            t.rollback();
            return null;
        }
    }

    public void deleteByObj(Applicant applicant, Company company, Position position) {
        Workhistory obj = findByObj(applicant, company, position);
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