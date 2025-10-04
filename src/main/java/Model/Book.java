package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int year;
    private boolean available;

    public Book(int id, String title, String author, String category, int year, boolean available){
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.available = available;
    }

    public Book(String title, String author, String category, int year, boolean available){
        this(-1, title, author, category, year, available);
    }
}
