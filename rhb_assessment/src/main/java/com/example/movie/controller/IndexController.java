package com.example.movie.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class IndexController {

    @GetMapping
    public String index() {
        return " Kindly access to movie/api/movies to test all the CRUD functions and access readme.md for further clarifications";
    }
}
