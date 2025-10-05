package Util;

import java.sql.Connection;
import java.util.Scanner;

public class userOptions {
    public static void userOptionsInterface(Connection conn){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while(choice != 6){
            System.out.println("Select An Option");
            System.out.println("1. View Available Books");
            System.out.println("2. View Your Checked Out Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Update Information");
            System.out.println("6. Logout");

            choice = scanner.nextInt();
            userOptionsSwitch(conn, choice);
        }

    }
    public static void userOptionsSwitch(Connection conn, int choice){

        switch(choice){
            case 1:
                System.out.println("Viewing available books");
                BookOperations.printAllAvailableBooks(conn);
                break;
            case 2:
                //TODO call borrow table to see what books you have checked out
                break;
            case 3:
                //TODO borrow a book. calling borrow table
                break;
            case 4:
                //TODO return a book you have checked out
                break;
            case 5:
                //TODO udate user info
                break;
            case 6:
                System.out.println("Logging out");
                System.exit(0);
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
}
