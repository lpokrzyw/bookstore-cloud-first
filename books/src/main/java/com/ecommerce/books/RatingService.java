package com.ecommerce.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private BookRepository bookRepository;

    public void addRating(int bookId, int score, String username) {
        Book book = bookRepository.findById(bookId);
        Rating rating = new Rating();
        rating.setBook(book);
        rating.setScore(score);
        rating.setUsername(username);
        ratingRepository.save(rating);
    }

    public Double getAverageRatingForBook(int bookId) {
        List<Rating> ratings = ratingRepository.findByBookId(bookId);
        if (ratings.isEmpty()) return null;

        return ratings.stream().mapToInt(Rating::getScore).average().orElse(0);
    }
}