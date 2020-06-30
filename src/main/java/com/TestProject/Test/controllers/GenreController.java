package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.GenreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
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
    @ApiOperation(value = "Searching whole books published in some Genre (Notes contains better explanation)",
            notes = "Using GET Mapping, method takes the genre`s name as PathVariable, and return" +
                    "List<Books> published in Genre, which has same name as passed",
            response = Contact.class)
    public List<Book> getAllbooksByGenre(@PathVariable String name) {
        return genreService.getAllBooksPublishedInGenre(name);
    }
}
