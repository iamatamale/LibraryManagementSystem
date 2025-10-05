package DAO;

import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static void insertBook(Connection conn, Book book){
        String sql = "INSERT INTO Book (title, author, category, year, available) VALUES (?,?,?,?,?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getCategory());
            pstmt.setInt(4, book.getYear());
            pstmt.setBoolean(5, book.isAvailable());
            pstmt.executeUpdate();

            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if(rs.next()){
                    book.setId(rs.getInt(1));
                }
            }
            System.out.println("Book inserted successfully: " + book.getTitle());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static List<Book> getAllBooks(Connection conn){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("year"),
                        rs.getBoolean("available")
                ));
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return books;
    }
    public static List<Book> getAvailableBooks(Connection conn){
        List<Book> availableBooks = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE available = 1";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    availableBooks.add(new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("category"),
                            rs.getInt("year"),
                            rs.getBoolean("available")
                    ));
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return availableBooks;
    }
    public static List<Book> getBorrowedBooks(Connection conn){
        List<Book> borrowedBooks = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE available = 0";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    borrowedBooks.add(new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("category"),
                            rs.getInt("year"),
                            rs.getBoolean("available")
                    ));
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return borrowedBooks;
    }
    public static void deleteBook(Connection conn, int id){
        String sql = "DELETE FROM Book WHERE id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Book deleted successfully");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
