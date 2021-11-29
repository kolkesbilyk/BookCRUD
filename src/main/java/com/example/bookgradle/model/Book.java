package com.example.bookgradle.model;

import lombok.Value;

@Value //аннотация позволяет сделать клас неизменяемым, добавляет геттеры и конструктор
public class Book {//клас сервисного слоя
    Long id;
    String author;
    String title;
    Double price;
}
