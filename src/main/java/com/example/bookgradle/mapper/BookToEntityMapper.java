package com.example.bookgradle.mapper;

import com.example.bookgradle.dao.BookEntity;
import com.example.bookgradle.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//виполняет за нас перекладивание из одного обьекта в другой
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}
