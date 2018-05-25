package Hibernate.Dao.Util;

import Hibernate.Dao.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(User.class)
                    .configure("hibernate.cfg.xml");

            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            standardServiceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }
}
