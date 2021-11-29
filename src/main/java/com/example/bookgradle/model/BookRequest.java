package com.example.bookgradle.model;

import lombok.Data;

@Data//генерирует геттер и сеттер
public class BookRequest {//клас, которий позволит выполнять http-запроси к нашему сервису
    private String author;
    private String title;
    private Double price;
}
