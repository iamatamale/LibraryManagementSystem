package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String url = "jdbc:sqlite:LibraryManagementSystem.db";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url);
    }

    //method to init db. dont use after init
    public static void initializeDB() {
        try( Connection conn = getConnection()){
            if(conn != null){
                var meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    //call to create tables and enable foreign keys
    public static void createTables(Connection conn){
        try(Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(bookTable());
            stmt.executeUpdate(userTable());
            stmt.executeUpdate(borrowTable());
            System.out.println("Tables created successfully");

            stmt.executeUpdate("PRAGMA foreign_keys=ON");
            System.out.println("Foreign keys enabled");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static String bookTable(){
     String bookTable = "CREATE TABLE IF NOT EXISTS Book (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "title TEXT NOT NULL," +
            "author TEXT NOT NULL," +
            "category TEXT NOT NULL," +
            "year INTEGER NOT NULL," +
            "available INTEGER NOT NULL)";
     return bookTable;
    }
    public static String userTable(){
        String userTable = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL UNIQUE," +
                "password TEXT NOT NULL," +
                "role TEXT NOT NULL)";
        return userTable;
    }

    public static String borrowTable(){
        String borrowTable = "CREATE TABLE IF NOT EXISTS Borrow (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "book_id INTEGER NOT NULL," +
                "user_id INTEGER NOT NULL," +
                "borrow_date TEXT NOT NULL," +
                "return_date TEXT NOT NULL," +
                "FOREIGN KEY(book_id) REFERENCES Book(id)," +
                "FOREIGN KEY(user_id) REFERENCES User(id))";
        return borrowTable;
    }


}
