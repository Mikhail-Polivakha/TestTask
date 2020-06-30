package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/name{name}")
    public List<Book> getAllbooksByGenre(@PathVariable String name) {
        return genreService.getAllBooksPublishedInGenre(name);
    }
}
