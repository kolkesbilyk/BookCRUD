package com.example.bookgradle.mapper;

import com.example.bookgradle.model.Book;
import com.example.bookgradle.model.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book addBookRequestToBook(BookRequest bookRequest);
    Book editBookRequestToBook(Long id, BookRequest bookRequest);
}
