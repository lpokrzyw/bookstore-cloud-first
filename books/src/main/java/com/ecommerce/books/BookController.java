package com.ecommerce.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(path = "/books")
@SessionAttributes("order")
public class BookController {
    @GetMapping
    public String showBooksPage() {
        return "books";
    }
    @Autowired private BookService bookService;
    @Autowired private CommentService commentService;
    @Autowired private RatingService ratingService;

    @GetMapping("/{id}")
    public String bookDetails(@PathVariable int id, Model model, Principal principal) {
        Optional<Book> book = bookService.getBookById(id);
        List<Comment> comments = commentService.getCommentsByBookId(id);
        Double averageRating = ratingService.getAverageRatingForBook(id);

        model.addAttribute("book", book);
        model.addAttribute("comments", comments);
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("newComment", new Comment());
        model.addAttribute("newRating", new Rating());
        model.addAttribute("currentUser", principal != null ? principal.getName() : "Anonim");

        return "book-details";
    }

    @PostMapping("/{id}/comment")
    public String addComment(@PathVariable int id, @ModelAttribute Comment newComment) {
        commentService.addComment(id, newComment.getContent(), newComment.getUsername());
        return "redirect:/books/" + id;
    }

    @PostMapping("/{id}/rate")
    public String addRating(@PathVariable int id, @ModelAttribute Rating newRating) {
        ratingService.addRating(id, newRating.getStars(), newRating.getUsername());
        return "redirect:/books/" + id;
    }
}
