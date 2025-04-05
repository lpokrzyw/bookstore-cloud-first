package com.ecommerce.cart;

import jakarta.persistence.*;

@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CART_TOTAL", nullable = false)
    public double cartTotal;

    public Cart() {
    }

    public Cart(int id, double cartTotal) {
        super();
        this.id = id;
        this.cartTotal = cartTotal;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
