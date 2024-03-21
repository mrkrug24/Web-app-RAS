package com.prosphere.ras;
import com.prosphere.ras.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
            try {
                sessionFactory = new MetadataSources(registry)
                                    .addAnnotatedClasses(   
                                                            Applicant.class, 
                                                            Company.class,
                                                            Education.class,
                                                            Position.class,
                                                            Speciality.class,
                                                            University.class,
                                                            Vacancy.class,
                                                            Workhistory.class)
                                    .buildMetadata()
                                    .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("getSessionFactory error");
                throw e;
            }
        }

        return sessionFactory;
    }
}