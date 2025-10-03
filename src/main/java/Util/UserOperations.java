package Util;
import Model.User;
import DAO.userDAO;

import java.sql.Connection;

public class UserOperations {
    public static void printUsers(Connection conn){
        for(User u : userDAO.getAllUsers(conn)){
            System.out.println(u);
        }
    }
    public static void printUserById(Connection conn, int id){
        User u = userDAO.getUserById(conn, id);
        if(u != null){
            System.out.println(u);
        }else{
            System.out.println("User not found");
        }
    }
}
