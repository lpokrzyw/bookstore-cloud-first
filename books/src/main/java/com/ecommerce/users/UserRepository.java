package com.ecommerce.users;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}
