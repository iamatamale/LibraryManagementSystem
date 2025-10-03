import java.sql.Connection;
import java.util.Scanner;

import Database.Database;
import Model.User;
import Util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        try(Connection conn = Database.getConnection()){
// UNCOMMENT LATER
            //Database.initializeDB();
            //Database.clearTables(conn);

            //UserOperations.createTestUsers(conn);
            //System.out.println("Connected to DB successfully");

            //Database.createTables(conn);
            //UserOperations.deleteUserByID(conn, 3);
            User activeUser = null;
            activeUser = loginOrRegister(conn);

           // UserOperations.printUsers(conn);
            //UserOperations.printUserById(conn,1);
            //UserOperations.printUserByEmail(conn, "<EMAIL>");

        }catch(Exception e){
            System.err.println(e.getMessage());
        }



    }
    public static User loginOrRegister(Connection conn){
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************");
        System.out.println("    Welcome to Library    ");
        System.out.println("**************************");
        System.out.println("Select An Option");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        User activeUser = null;
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                activeUser = UserOperations.loginUser(conn);
            case 2:
                activeUser = UserOperations.registerNewUser(conn);
                break;
        }
        return activeUser;
    }

}
