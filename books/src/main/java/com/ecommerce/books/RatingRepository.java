package com.ecommerce.books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByBookId(int bookId);  // Use int for bookId
}