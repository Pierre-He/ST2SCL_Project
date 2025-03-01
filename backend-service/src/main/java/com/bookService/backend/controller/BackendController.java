package com.bookService.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackendController {
    @GetMapping
    public String home() {
        return "Welcome to the Book Service BACKEND API!";
    }
}
