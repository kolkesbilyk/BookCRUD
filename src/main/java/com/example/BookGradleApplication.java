package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//добавляет аннотации: @Configuration, @EnableAutoConfiguration, @ComponentScan; сканирует все свои подпакеты
public class BookGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookGradleApplication.class, args);
	}

}
