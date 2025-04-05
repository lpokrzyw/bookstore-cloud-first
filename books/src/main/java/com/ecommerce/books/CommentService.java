package com.ecommerce.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Comment> getCommentsByBookId(int bookId) {
        return commentRepository.findByBookId(bookId);  // Use int
    }

    public void addComment(int bookId, String content, String username) {
        Book book = bookRepository.findById(bookId);
        Comment comment = new Comment();
        comment.setBook(book);
        comment.setContent(content);
        comment.setUsername(username);
        commentRepository.save(comment);
    }
}