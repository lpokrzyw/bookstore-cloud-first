package com.ecommerce.books.cart;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findCartById(int id);
}
