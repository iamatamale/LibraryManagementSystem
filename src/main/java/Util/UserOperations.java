package Util;
import Model.User;
import DAO.UserDAO;

import java.sql.Connection;

public class UserOperations {
    public static void printUsers(Connection conn){
        for(User u : UserDAO.getAllUsers(conn)){
            System.out.println(u);
        }
    }
    public static void printUserById(Connection conn, int id){
        User u = UserDAO.getUserById(conn, id);
        if(u != null){
            System.out.println(u);
        }else{
            System.out.println("User not found");
        }
    }
    public static void printUserByEmail(Connection conn, String email){
        User u = UserDAO.getUserByEmail(conn, email);
        if(u != null){
            System.out.println(u);
        }else{
            System.out.println("User not found");
        }
    }
    public static void createTestUsers(Connection conn){
        User u = new User("test", "<EMAIL>", "test", "user");
        User user = new User("test", "test", "test", "user");
        User user2 = new User("admin", "admin@gmail.com", "pw", "admin");
        User dupEmail = new User("HACKER", "hacked@haha.com", "goob", "admin");


        UserDAO.insertUser(conn, u);
        UserDAO.insertUser(conn, user);
        UserDAO.insertUser(conn, user2);
        UserDAO.insertUser(conn, dupEmail);

    }
    public static void deleteUserByID(Connection conn, int id){
        UserDAO.deleteUser(conn, id);
    }

}
