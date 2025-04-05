package com.ecommerce.cart;

import com.ecommerce.books.Book;
import com.ecommerce.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CartController {
    private final int CART_ID = 1;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> retrieveBook(int id) {
        return Optional.ofNullable(bookRepository.findById(id));
    }

    public Cart retrieveCart(int id) {
        // If the cart does not exist, create a new one and save it
        return cartRepository.findById(id).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setCartTotal(0.0); // Initialize the cart total to 0
            cartRepository.save(newCart); // Save the newly created cart
            return newCart;
        });
    }

    @GetMapping(path = "/cart")
    public String showCartPage(Model model) {
        model.addAttribute("cartTotal",
                String.format("%.2f", retrieveCart(CART_ID).getCartTotal()));
        return "cart";
    }

    public void updateCartTotal(double cartTotal) {
        Cart myCart = retrieveCart(CART_ID);
        myCart.cartTotal = cartTotal;
        cartRepository.save(myCart);
    }

    @PostMapping(path = "/cart")
    public String processOrder() {
        updateCartTotal(0);
        return "redirect:/goodbye";
    }

    @RequestMapping(path = "/cart/addToCart")
    public String addToCart(Model model, @RequestParam(value = "code", defaultValue = "") String code) {

        model.addAttribute("productCode", code);
        int bookId = Integer.valueOf(code);

        Optional<Book> optionalBook = retrieveBook(bookId);

        if (optionalBook.isPresent()) {
            // Book exists, update the cart total
            double bookPrice = optionalBook.get().getPrice();
            updateCartTotal(retrieveCart(CART_ID).getCartTotal() + bookPrice);
        } else {
            // Book not found, handle the error case (optional, can be an error message)
            model.addAttribute("error", "Book not found with ID: " + bookId);
            return "error";
        }

        return "redirect:/books";
    }

    @GetMapping(path = "/goodbye")
    public String showGoodbyePage() {
        return "goodbye";
    }
}
