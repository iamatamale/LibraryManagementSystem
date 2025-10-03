package DAO;

import Model.User;
import Database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDAO {

    public static void insertUser(Connection conn, User user){
        String sql = "INSERT INTO User (name, email, password, role) VALUES (?,?,?,?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole());
            pstmt.executeUpdate();
            System.out.println("User inserted successfully: " + user.getName());
        } catch (SQLException e){
            if(e.getMessage().contains("UNIQUE constraint failed") ){
                System.err.println("Email already exists");
            }else{
                System.err.println(e.getMessage());
            }
        }
    }

    public static List<User> getAllUsers(Connection conn){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return users;
    }

    public static User getUserById(Connection conn, int id){
        User user = null;
        String sql = "SELECT * FROM User WHERE id = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            try(ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                    );
                }
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return user;
    }
}