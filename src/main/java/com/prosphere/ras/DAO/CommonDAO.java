package com.prosphere.ras.DAO;
import org.hibernate.Session;
import java.util.List;
import com.prosphere.ras.HibernateSessionFactory;
import org.hibernate.Transaction;

// applicant
// university
// speciality
// position
// company

public abstract class CommonDAO<T> {
    private final Class<T> entityClass;

    public CommonDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T findById(Integer id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            T res = session.get(entityClass, id);
            t.commit();
            return res;
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            List<T> res = session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
            t.commit();
            return res;
        }
    }

    public void save(T obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            try {
                session.persist(obj);
                t.commit();
            } catch (Exception e) {
                System.out.println("save error: " + e);
                t.rollback();
            }
        }
    }

    public void update(T obj) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            try {
                session.merge(obj);
                t.commit();
            } catch (Exception e) {
                System.out.println("update error " + e);
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

    public void deleteById(Integer id) {
        T obj = findById(id);
        if (obj != null) {
            try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
                Transaction t = session.beginTransaction();
                session.remove(obj);
                t.commit();
            }
        } else {
            System.out.println("deleteById error");
        }
    }
}