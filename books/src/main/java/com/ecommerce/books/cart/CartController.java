package com.ecommerce.books.cart;

import com.ecommerce.books.books.Book;
import com.ecommerce.books.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("order")
public class CartController {
    private final int CART_ID = 1; // hard coded for now

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public Book retrieveBook(int id) {
        return bookRepository.findBookById(id);
    }

    public Cart retrieveCart(int id) {
        return cartRepository.findCartById(id);
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
    public String processOrder(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        updateCartTotal(0);
        return "redirect:/goodbye";
    }

    @RequestMapping(path = "/cart/addToCart")
    public String addToCart(Model model, @RequestParam(value = "code", defaultValue = "") String code) {

        model.addAttribute("productCode", code);
        double bookPrice = retrieveBook(Integer.valueOf(code)).getPrice();
        updateCartTotal(retrieveCart(CART_ID).getCartTotal() + bookPrice);

        return "redirect:/books";
    }

    @GetMapping(path = "/goodbye")
    public String showGoodbyePage() {
        return "goodbye";
    }
}
