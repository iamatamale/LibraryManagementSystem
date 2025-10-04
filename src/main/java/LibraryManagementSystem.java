import java.sql.Connection;
import java.util.Scanner;

import DAO.*;
import Model.*;
import Util.*;
import Database.Database;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        try(Connection conn = Database.getConnection()){
// UNCOMMENT LATER
//            Database.initializeDB();
//            Database.clearTables(conn);
//             Database.createTables(conn);

            //UserOperations.createTestUsers(conn);

            //System.out.println("Connected to DB successfully");

            //UserOperations.deleteUserByID(conn, 3);

            User activeUser = null;
            //activeUser = loginOrRegister(conn);

            activeUser = UserDAO.getUserByEmail(conn, "admin@gmail.com");
            //System.out.println("Active User: " + activeUser.getName());

            if(activeUser.getRole().equals("admin")){
                adminOptions.adminOptionsInterface(conn);
            }else if(activeUser.getRole().equals("user")){
                userOptions.userOptionsInterface(conn);
            }else{
                System.out.println("User missing role. Contact admin.");
                System.exit(15);
            }
//
//            System.out.println("All users:");
//            UserOperations.printUsers(conn);

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
                break;
            case 2:
                activeUser = UserOperations.registerNewUser(conn);
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid Option");
                System.exit(0);
        }
        return activeUser;
    }

}
