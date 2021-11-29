package com.example.bookgradle.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data                   //добавляет геттер и сеттер
@NoArgsConstructor      //конструктор без аргументов
@AllArgsConstructor     //конструктор со всеми аргументами
@Entity                 //указиваем что обьект етого класа - БД
@Table(name = "books")  //указиваем название таблицы
public class BookEntity {//клас соответствует таблице в БД
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private Double price;
}
