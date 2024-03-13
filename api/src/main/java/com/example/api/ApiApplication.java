package com.example.api;

import com.example.api.models.Book;
import com.example.api.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        var test = SecurityContextHolder.getContext().getAuthentication();
    }

    @Bean
    public CommandLineRunner demoData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Book 1", "Author 1", 2022));
            bookRepository.save(new Book("Book 2", "Author 2", 2023));
            bookRepository.save(new Book("Book 3", "Author 3", 2024));
        };
    }
}
