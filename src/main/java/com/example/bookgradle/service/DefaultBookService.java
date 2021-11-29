package com.example.bookgradle.service;

import com.example.bookgradle.dao.BookEntity;
import com.example.bookgradle.dao.BookRepository;
import com.example.bookgradle.exception.BookNotFoundException;
import com.example.bookgradle.mapper.BookToEntityMapper;
import com.example.bookgradle.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service                                            //Spring создаст Bean етого класа
@RequiredArgsConstructor                            //генерирует конструктор с необходимыми аргументами
public class DefaultBookService implements BookService{ //сервисный слой

    private final BookRepository bookRepository;    //обьект которий может взаимодействовать с БД
    private final BookToEntityMapper mapper;        //обьект для перекладивания одного обьекта в другой

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)//возвращает обьект Optional - тип которий может содержать, а может и не содержать значение
                .orElseThrow(() -> new BookNotFoundException("Book not found: id " + id));//проверка на null
        return mapper.bookEntityToBook(bookEntity);//исключение будет создаваться только в случае отсутствия Optional
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
