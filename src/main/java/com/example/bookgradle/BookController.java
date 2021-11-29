package com.example.bookgradle;

import com.example.bookgradle.mapper.BookToDtoMapper;
import com.example.bookgradle.model.Book;
import com.example.bookgradle.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;

    @ResponseBody
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){//параметр метода связан с переменной из URL-адреса
        return bookService.getBookById(id);
    }

    @GetMapping("/books")
    public String getAllBooks(Model model, @RequestParam(required = false) String author){
        if (author != null) {
            List<Book> book = bookService.findByAuthor(author);
            model.addAttribute("books", book);
        }else {
            List<Book> allBooks = bookService.getAllBooks();
            model.addAttribute("books", allBooks);
        }
        return "books-list";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book){
        return "book-create";
    }

    @PostMapping("/book-create")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "/book-update";
    }
    @PostMapping("/book-update")
    public String updateBook(Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }
}
