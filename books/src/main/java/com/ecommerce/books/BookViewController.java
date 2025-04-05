package com.ecommerce.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/view/books")
public class BookViewController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("/{id}")
    public String bookDetails(@PathVariable int id, Model model) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id));
        if (book.isPresent()) {
            model.addAttribute("book", book.get()); // book.get() wyciąga Book z Optionala
            model.addAttribute("averageRating", book.get().getAverageRating());
            return "book-details";
        }
        return "redirect:/";
    }

    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable int id, @RequestParam String userName, @RequestParam String text) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id));
        if (book.isPresent()) {
            Comment comment = new Comment();
            comment.setUsername(userName);
            comment.setContent(text);
            comment.setBook(book.get()); // przypisujemy książkę do komentarza
            commentRepository.save(comment);
        }
        return "redirect:/view/books/" + id;
    }

    @PostMapping("/{id}/ratings")
    public String addRating(@PathVariable int id, @RequestParam int stars) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id));
        if (book.isPresent()) {
            Rating rating = new Rating();
            rating.setScore(stars);
            rating.setBook(book.get()); // przypisujemy książkę do oceny
            ratingRepository.save(rating);
        }
        return "redirect:/view/books/" + id;
    }
}