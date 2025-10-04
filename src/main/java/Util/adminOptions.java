package Util;

import java.sql.Connection;
import java.util.Scanner;

public class adminOptions {
    public static void adminOptionsInterface(Connection conn){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while(choice != 8){
            System.out.println("ADMIN VIEW");
            System.out.println("Select An Option");
            System.out.println("1. View All Books");
            System.out.println("2. View All Borrowed Books");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Book");
            System.out.println("5. View All Users");
            System.out.println("6. Update User Info");
            System.out.println("7. Remove User");
            System.out.println("8. Logout");

            choice = scanner.nextInt();

            adminOptionsSwitch(conn, choice);
        }
    }
    public static void adminOptionsSwitch(Connection conn, int choice){
        Scanner scanner = new Scanner(System.in);
        switch(choice){
            case 1:
                System.out.println("Viewing all books");
                BookOperations.printAllBooks(conn);
                System.out.println("");
                System.out.println("Press any key and enter to continue...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Viewing all borrowed books");
                BookOperations.printAllBorrowedBooks(conn);
                System.out.println("");
                System.out.println("Press any key and enter to continue...");
                scanner.nextLine();
                break;
            case 8:
                System.out.println("Logging out");
                System.exit(0);
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
}
