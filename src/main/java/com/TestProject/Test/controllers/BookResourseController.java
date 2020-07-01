package com.TestProject.Test.controllers;

import com.TestProject.Test.dto_layer.BookDTO;
import com.TestProject.Test.services.BookService;
import com.TestProject.Test.exceptions.SourceNotFoundException;
import com.TestProject.Test.domain.Book;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Library")
public class BookResourseController {

    @Autowired
    BookService bookService;

    @Autowired
    ModelMapper modelMapper;

    //TODO: Expand the functional by getting, posing, deliting and e.t.c
    // the book not from some source root 'Library', but from certain Library

//    @RequestMapping(method = RequestMethod.GET, value = "/Library/{id}")
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get Certain book from repository",
                notes = "Using the GET Mapping  for '/{id}' id - book primary key you can fetch proper book" +
                        "by calling getBookById() method from BookService Service",
                response = Contact.class)
        public BookDTO getBook(@ApiParam(value = "Input the book ID (String type) the book you want to retrieve",
                        required = true)
            @PathVariable String id) {
        try {
            return modelMapper.map(bookService.getBookById(id), BookDTO.class);
        } catch (SourceNotFoundException e) {
            return new BookDTO();
        }
    }

    @ApiOperation(value = "Getting all books from repoitory",
                notes = "Using GET Mapping from the root '/Library', you fetch all books from repository" +
                        "by calling getAllBooks() method from BookService." +
                        "Returning type: List<Book>. Takes no argument",
                response = Contact.class)
//    @RequestMapping(method = RequestMethod.GET, value = "/Library")
    @GetMapping(value = "/")
    public List<BookDTO> getAllbooks() {
        return bookService.getAllBooks()
                .stream()
                .map(this::convertBookToDTO)
                .collect(Collectors.toList());
    }


    @ApiOperation(value = "Saving the book in Repository",
                notes = "Using POST Mapping from the root, you can save some book in the repository by " +
                        "calling saveBook() method from BookService Service. The " +
                        "request body must contain Book you want to save. Returns void.",
                response = Contact.class)
//    @RequestMapping(method = RequestMethod.POST, value = "/Library")
    @PostMapping(value = "/")
    public void saveBook(@ApiParam(value = "Takes a parameter - book instance (stored in request Body) you want to Save")
                             @RequestBody Book book) {
        bookService.saveBook(book);
    }

    @ApiOperation(value = "Deleting book from repository",
                notes = "Using DELETE Mapping, you can DELETE from repository book instance (Standart Root 'Library'). " +
                        "Request Body must store the book you want to delete from repository",
                response = Contact.class)
//    @RequestMapping(method = RequestMethod.DELETE, value = "/Library")
    @DeleteMapping(value = "/")
    public void deleteBook(@ApiParam(value = "Takes a parameter - book instance (stored in Request Body) you want to delete")
                               @RequestBody Book bookTodelete) {
        try {
            bookService.deleteBook(bookTodelete);
        } catch (SourceNotFoundException e) {
            System.out.println("No such element");
        }
    }

    @ApiOperation(value = "Updating book fields",
                notes = "This method takes parameter - updatetedBook." +
                        "By using it, call updateBook() method from BookService Srvice. If the book exists, " +
                        "updateBook() method will resave book with the id same as id of input book (Id - primary Key), if" +
                        "there is no such book in repository, then updateBook() method will create a new one book with the same" +
                        "fields (I mean, equals fields with the updatedBook)",
                response = Contact.class)
//    @RequestMapping(method = RequestMethod.PUT, value = "/Lirary/{id}")
    @PutMapping(value = "/")
    public void updateBookInformation(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    private BookDTO convertBookToDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }
}
