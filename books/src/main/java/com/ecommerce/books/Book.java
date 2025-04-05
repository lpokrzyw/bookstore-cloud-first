package com.ecommerce.books;

import com.ecommerce.comments.Comment;
import com.ecommerce.ratings.Rating;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    private int id;
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    public Book() {
    }

    public Book(int id, String title, String author, String description, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price; // Set price
    }

    // Override equals and hashCode based on ID (primary key)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;  // Compare books by their ID
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);  // Generate hashCode based on ID
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public double getAverageRating() {
        return ratings.stream()
                .mapToInt(Rating::getScore)
                .average()
                .orElse(0.0);
    }

    public List<Comment> getComments() {
        return comments;  // Return the list of comments
    }
}