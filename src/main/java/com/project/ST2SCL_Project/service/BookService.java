package com.project.ST2SCL_Project.service;

import com.project.ST2SCL_Project.model.Book;
import com.project.ST2SCL_Project.model.BorrowPeriod;
import com.project.ST2SCL_Project.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Initialize with two books
        books.add(new Book("War and Peace"));
        books.add(new Book("Invisible Man"));
        books.add(new Book("Metro"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String title, BorrowPeriod borrowPeriod) throws BookNotFoundException {
        Book book = getBookByTitle(title);
        if (book != null) {
            book.setBorrowed(true);
            book.addBorrowPeriod(borrowPeriod);
        } else {
            throw new BookNotFoundException(title);
        }
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book book = getBookByTitle(title);
        if (book != null) {
            book.setBorrowed(false);
        } else {
            throw new BookNotFoundException(title);
        }
    }
}