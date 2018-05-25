package Hibernate.Dao.Interfaces;

import Hibernate.Dao.Entity.User;

public interface UserDao {
    void insert(User user);
    User select(int primarykey);
    void shutdownSession();
}
