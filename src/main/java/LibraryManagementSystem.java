import java.sql.Connection;

import Database.Database;
import Model.User;
import Util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        try(Connection conn = Database.getConnection()){
            //UserOperations.createTestUsers(conn);
            //Database.initializeDB();
            //System.out.println("Connected to DB successfully");

            //Database.createTables(conn);

            UserOperations.printUsers(conn);
            //UserOperations.printUserById(conn,1);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }



    }

}
