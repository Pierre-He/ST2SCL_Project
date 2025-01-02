package com.project.ST2SCL_Project.controller;
import com.project.ST2SCL_Project.exception.BookNotFoundException;
import com.project.ST2SCL_Project.model.Book;
import com.project.ST2SCL_Project.model.BorrowPeriod;
import com.project.ST2SCL_Project.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class BookController {

    private final BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Book Store. Type /books in URL to get all books";
    }


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PutMapping(value = "/books/{title}")
    public void borrowBook(
            @PathVariable("title") String title,
            @RequestParam(value = "borrow", required = true) boolean borrow,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate) throws BookNotFoundException {

        logger.info("Title: " + title);
        logger.info("Borrow: " + borrow);

        if (borrow) {
            BorrowPeriod borrowPeriod = new BorrowPeriod(LocalDate.parse(startDate), LocalDate.parse(endDate));
            bookService.borrowBook(title, borrowPeriod);
        } else {
            bookService.returnBook(title);
        }
    }



}