package com.example.BookStore.entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookStore {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name="id")
   private int id;

   @Column(name="bookId",unique = true)
   private String bookId;

   @Column(name="title")
   private String title;

   @Column(name="author")
   private String author;

   @Column(name="genre")
    private String genre;

   @Column(name="price")
    private double price;

   public BookStore(){}

    public BookStore(int id,String title,String author,String genre, double price,String bookId){
       this.id = id;
       this.title = title;
       this.author = author;
       this.genre = genre;
       this.price = price;
       this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "id=" + id +
                "bookId=" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
