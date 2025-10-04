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
}
