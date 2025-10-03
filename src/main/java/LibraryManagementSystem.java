import java.sql.Connection;

import DAO.userDAO;
import Database.Database;
import Model.User;
import Util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        User user = new User("test", "test", "test", "user");
        User user2 = new User("admin", "admin@gmail.com", "pw", "admin");
        User dupEmail = new User("HACKER", "hacked@haha.com", "goob", "admin");
        try(Connection conn = Database.getConnection()){

            //Database.initializeDB();
            //System.out.println("Connected to DB successfully");

            //Database.createTables(conn);

            //userDAO.insertUser(conn, user);
            //userDAO.insertUser(conn, user2);
           // userDAO.insertUser(conn, dupEmail);


            //UserOperations.printUsers(conn);
            UserOperations.printUserById(conn,1);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }



    }

}
