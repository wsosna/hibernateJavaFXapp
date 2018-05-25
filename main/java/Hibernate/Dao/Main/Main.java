package Hibernate.Dao.Main;


import Hibernate.Dao.Entity.User;
import Hibernate.Dao.Util.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    //Klasa do testowania bazy danych
    public static void main(String[] args) {
        testConnection();

        UserDaoImpl database = new UserDaoImpl();

        User user1 = new User("NickMoj","passsw");
        database.insert(user1);

        User user = database.select(1);
        System.out.println(user);
        database.shutdownSession();


    }
    public static void testConnection() {
        //127.0.0.1 - zamiast localhost
        String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/mojabaza";
        String user = "****";
        String pass = "***";

        try {
            System.out.println("Start connect...");
            Connection connect = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Successful connect :)");
        }
        catch (Exception exc) {
            System.out.println("Ooppss :/");
            exc.printStackTrace();
        }
    }
}
