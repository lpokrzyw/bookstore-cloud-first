package com.ecommerce.books.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/books")
@SessionAttributes("order")
public class BookController {
    @GetMapping
    public String showBooksPage() {
        return "books";
    }
}
