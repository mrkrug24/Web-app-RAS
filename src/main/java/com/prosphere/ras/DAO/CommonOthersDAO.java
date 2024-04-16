package com.prosphere.ras.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.prosphere.ras.util.HibernateSessionFactory;

public abstract class CommonOthersDAO<T> {
    private Class<T> entityClass;

    public CommonOthersDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public List<T> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            List<T> b = session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
            t.commit();
            return b;
        }
    }

    public void update(T obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            try {
                session.merge(obj);
                t.commit();
            } catch (Exception e) {
                System.out.println("update error: " + e);
                t.rollback();
            }
        }
    }

    public void delete(T obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            try {
                session.remove(obj);
                t.commit();
            } catch (Exception e) {
                System.out.println("delete error: " + e);
                t.rollback();
            }
        }
    }
}