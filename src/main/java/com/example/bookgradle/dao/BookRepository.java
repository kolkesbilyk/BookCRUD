package com.example.bookgradle.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//интерфейс для загрузки и сохранения записей в БД
//даное наследование позволяет нам получитьфункциональность CRUD(Create, Read, Update, Delete)
public interface BookRepository extends CrudRepository<BookEntity, Long> {
    List<BookEntity> findAllByAuthorContaining(String author);
}
