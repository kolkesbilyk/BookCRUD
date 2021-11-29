package com.example.bookgradle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        return "Hello, " + name;
    }
}
