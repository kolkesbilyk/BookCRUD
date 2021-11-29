package com.example.bookgradle.service;

import com.example.bookgradle.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> findByAuthor(String author);
    void addBook(Book book);
    void deleteBook(Long id);
}
