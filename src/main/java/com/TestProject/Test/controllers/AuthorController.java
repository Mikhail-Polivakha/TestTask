package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
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
    @ApiOperation(value = "Searching whole books written by some author by using the Author`s ID",
                notes = "Using GET Mapping, method takes the author`s ID as PathVariable, and return" +
                        "List<Books> written by author, which has same ID as passed",
                response = Contact.class)
    public List<Book> getAllBooksByAuthorsId(@PathVariable String id) {
        return authorService.getAllBooksClaimedToAuthorById(id);
    }

    @GetMapping("/firstName{firstName}")
    @ApiOperation(value = "Searching whole books written by some author by using the Author`s name",
            notes = "Using GET Mapping, method takes the author`s name as PathVariable, and return" +
                    "List<Books> written by author, which has same name as passed",
            response = Contact.class)
    public List<Book> getAllBooksAuthorsFirstName(@PathVariable String firstName) {
        return authorService.getAllBooksClaimedToAuthorByFirstName(firstName);
    }

    @GetMapping("/lastName{lastName}")
    @ApiOperation(value = "Searching whole books written by some author by using the Author`s Surname",
            notes = "Using GET Mapping, method takes the author`s Surname as PathVariable, and return" +
                    "List<Books> written by author, which has same Surname as passed",
            response = Contact.class)
    public List<Book> getAllBooksAuthorsLastName(@PathVariable String lastName) {
        return authorService.getAllBooksClaimedToAuthorByLastName(lastName);
    }

    @PostMapping("/")
    @ApiOperation(value = "Saving Author in some Book`s Author List",
            notes = "Using POST Mapping, method takes the Author Object in Request Body and bookId as" +
                    "Path variable. It allow us to Find the book with the id equal as passed, and save in" +
                    "this certain book`s Author List by adding there an Author object was passed in Request Body",
            response = Contact.class)
    public void addTheAuthorToBookByBookId(@RequestBody Author author, @PathVariable String bookID) {
        authorService.addAuthorToTheBook(author, bookID);
    }

    //TODO: Find out how to declare 2 diffrent virables in http request one root (Id of the proper book and
    // Id of the Author to delete)
    @DeleteMapping("/{bookId}/{authorID}")
    @ApiOperation(value = "Deleting Author in some Book`s Author List",
            notes = "Using Delete Mapping, method takes the Author`s id as Path Variable and bookId as" +
                    "Path variable. It allow us to Find the book with the id equal as passed, and delete in" +
                    "this certain book`s Author List an author, which has the same id as passed",
            response = Contact.class)
    public void deleteTheAuthorFromBooksAuthors(@PathVariable String bookID, @PathVariable String authorId) {
        authorService.deleteAuthor(bookID, authorId);
    }

    @PutMapping("/{bookId}")
    @ApiOperation(value = "Update Author in some Book`s Author List",
            notes = "Using PUT Mapping, method takes the Author Object in Request Body and bookId as" +
                    "Path variable. It allow us to Find the book with the id equal as passed, and update in" +
                    "this certain book`s Author List information about the author by resaving the object",
            response = Contact.class)
    public void updateTheAuthorbyBookId(@PathVariable String bookId, @RequestBody Author author) {
        authorService.updateAuthor(bookId, author);
    }
}
