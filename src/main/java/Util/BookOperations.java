package Util;

import DAO.BookDAO;
import Model.Book;

import java.sql.Connection;

public class BookOperations {
    public static void printAllBooks(Connection conn){
        for(Book b : BookDAO.getAllBooks(conn)){
            System.out.println(b);
        }
    }
    public static void printAllBorrowedBooks(Connection conn){
        for(Book b : BookDAO.getBorrowedBooks(conn)){
            System.out.println(b);
        }
    }
    public static void addTestBooks(Connection conn){
        Book b = new Book("The Hobbit", "<NAME>", "Fantasy", 1937, true);
        Book b2 = new Book("The Lord of the Rings", "<NAME>", "Fantasy", 1954, true);
        Book b3 = new Book("The Hunger Games", "<NAME>", "Fantasy", 2008, true);
        Book b4 = new Book("The Dark Tower", "<NAME>", "Fantasy", 2012, true);
        Book b5 = new Book("The Shining", "<NAME>", "Fantasy", 2013, true);
        Book b6 = new Book("The Iron Man", "<NAME>", "Action", 2008, true);
        Book b7 = new Book("The Wolf of Wall Street", "<NAME>", "Political", 2013, true);
        Book b8 = new Book("The Dark Knight", "<NAME>", "Action", 2008, true);
        Book b9 = new Book("The Lord of the Rings: The Return of the King", "<NAME>", "Fantasy", 2003, true);
        Book b10 = new Book("The Lord of the Rings: The Two Towers", "<NAME>", "Fantasy", 2002, true);
        Book b11 = new Book("The Lord of the Rings: The Fellowship of the Ring", "<NAME>", "Fantasy", 2001, false);
        Book b12 = new Book("The Lord of the Rings: The Return of the King", "<NAME>", "Fantasy", 2003, false);
        Book b13 = new Book("The Best Test Data Book", "<NAME>", "TEST DATA", 2025, false);

        BookDAO.insertBook(conn, b);
        BookDAO.insertBook(conn, b2);
        BookDAO.insertBook(conn, b3);
        BookDAO.insertBook(conn, b4);
        BookDAO.insertBook(conn, b5);
        BookDAO.insertBook(conn, b6);
        BookDAO.insertBook(conn, b7);
        BookDAO.insertBook(conn, b8);
        BookDAO.insertBook(conn, b9);
        BookDAO.insertBook(conn, b10);
        BookDAO.insertBook(conn, b11);
        BookDAO.insertBook(conn, b12);
        BookDAO.insertBook(conn, b13);
    }
}
