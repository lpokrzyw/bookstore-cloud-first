package com.ecommerce.config;

import com.ecommerce.users.User;
import com.ecommerce.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
            userRepository.save(new User("user", passwordEncoder.encode("user123"), "ROLE_USER"));
            userRepository.save(new User("lukasz", passwordEncoder.encode("tojesthaslo"), "ROLE_USER"));
        };
    }
}