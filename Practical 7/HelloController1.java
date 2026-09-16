package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }
}
