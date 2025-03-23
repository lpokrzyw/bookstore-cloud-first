package com.ecommerce.books.books;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    private int id;
    @Column(name = "PRICE", nullable = false)
    private double price;

    public Book() {
    }

    public Book(int id, double price) {
        super();
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
