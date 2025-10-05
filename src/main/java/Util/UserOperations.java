package Util;
import Model.User;
import DAO.UserDAO;

import java.sql.Connection;
import java.util.Scanner;

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

    public static User registerNewUser(Connection conn){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter email");
        String email = scanner.nextLine();

        while(UserDAO.checkIfEmailInUse(conn, email)){
            System.out.println("Email already in use");
            System.out.println("Enter email");
            email = scanner.nextLine();
        }

        System.out.println("Enter password");
        String password = scanner.nextLine();

        User registeredUser =   new User(name, email, password, "user");
        UserDAO.insertUser(conn, registeredUser);
        return registeredUser;
    }
    public static User loginUser(Connection conn){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email");
        String email = scanner.nextLine();


        User activeUser = null;
        User user = UserDAO.getUserByEmail(conn, email);
        if(user != null){
            System.out.println("Enter your password");
            String password = scanner.nextLine();
            if(user.getPassword().equals(password)){
                activeUser = user;
            }else{
                System.out.println("Incorrect password");
            }
        }else{
            System.out.println("User not found");
        }
        return activeUser;
    }
    public static void adminUpdateUserInfo(Connection conn, int id){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        User user = UserDAO.getUserById(conn, id);

        while(choice != 4){
            System.out.println("Select what to update: ");
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. Password");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
        }

        switch(choice){
            case 1:
                System.out.println("Enter new name");
                String newName = scanner.nextLine();
                user.setName(newName);
                UserDAO.updateUser(conn, user);
                break;
            case 2:
                System.out.println("Enter new email");
                String newEmail = scanner.nextLine();
                while(UserDAO.checkIfEmailInUse(conn, newEmail)){
                    System.out.println("Email already in use");
                    newEmail = scanner.nextLine();
                }
                user.setEmail(newEmail);
                UserDAO.updateUser(conn, user);
                break;
            case 3:
                System.out.println("Enter new password");
                String newPassword = scanner.nextLine();
                user.setPassword(newPassword);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
}
