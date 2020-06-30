package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/id{id}")
    public List<Book> getAllBooksByAuthorsId(@PathVariable String id) {
        return authorService.getAllBooksClaimedToAuthorById(id);
    }

    @GetMapping("/firstName{firstName}")
    public List<Book> getAllBooksAuthorsFirstName(@PathVariable String firstName) {
        return authorService.getAllBooksClaimedToAuthorByFirstName(firstName);
    }

    @GetMapping("/lastName{lastName}")
    public List<Book> getAllBooksAuthorsLastName(@PathVariable String lastName) {
        return authorService.getAllBooksClaimedToAuthorByLastName(lastName);
    }
}
