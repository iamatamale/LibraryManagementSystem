package Util;

import java.sql.Connection;
import java.util.Scanner;

public class userOptions {
    public static void userOptionsInterface(Connection conn){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select An Option");
        System.out.println("1. View Available Books");
        System.out.println("2. View Your Checked Out Books");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Update Information");
        System.out.println("6. Logout");
    }
}
