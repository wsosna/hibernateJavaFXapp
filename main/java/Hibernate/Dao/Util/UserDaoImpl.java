package Hibernate.Dao.Util;


import Hibernate.Dao.Entity.User;
import Hibernate.Dao.Interfaces.UserDao;
import org.hibernate.Session;

public class UserDaoImpl implements UserDao {
    private Session session;

    public UserDaoImpl() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public void insert (User user){
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Ops...");
        }
    }

    public User select (int primarykey){
        User tempUser = null;
        try {
            session.beginTransaction();
            tempUser = session.get(User.class, primarykey);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Ops...");
        }
        return tempUser;
    }

    public void shutdownSession() {
        HibernateSessionFactory.shutdown();
    }

    public Session getSession() {
        return session;
    }
}
