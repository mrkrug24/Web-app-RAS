package com.prosphere.ras.DAO;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.prosphere.ras.util.HibernateSessionFactory;
import jakarta.persistence.TypedQuery;
import com.prosphere.ras.models.*;

public class CompanyDAO extends CommonDAO<Company> {
    public CompanyDAO(){
        super(Company.class);
    }

    public Company findByName(String name) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            List<Company> result = session
                            .createQuery("from Company where name = :name", Company.class)
                            .setParameter("name", name)
                            .getResultList();
            t.commit();
            
            if (result.isEmpty()) return null;
            else return result.get(0);
        }
    }

    public List<Position> findNewPositions(Company company) {
        try (Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            StringBuilder queryString = new StringBuilder("SELECT p FROM Position p ");
            queryString.append("WHERE p.id NOT IN :cur_positions");

            TypedQuery<Position> query = session.createQuery(queryString.toString(), Position.class);

            List<Integer> cur_positions = new ArrayList<>();
            for (Vacancy vacancy : company.getCompVac()) cur_positions.add(vacancy.getPosition().getId());
            query.setParameter("cur_positions", cur_positions);

            List<Position> res = query.getResultList();
            t.commit();

            return res;
        }
    }

    public List<Vacancy> findVacancy(Company obj) {
        return obj.getCompVac();
    }
}