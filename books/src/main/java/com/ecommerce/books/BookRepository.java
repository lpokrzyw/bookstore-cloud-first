package com.ecommerce.books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //Book findByBookId(int id);
    Book findById(int id);
}
