package com.TestProject.Test.controllers;

import com.TestProject.Test.TestApplication;
import com.TestProject.Test.domain.Author;
import com.TestProject.Test.dto_layer.AuthorDTO;
import com.TestProject.Test.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    ModelMapper modelMapper = TestApplication.modelMapper();

    @GetMapping("/")
    @ApiOperation(value = "Getting whole Authors from repository",
                notes = "Using GET Mapping, method returns List<Authors> - all authors, exists in repository",
                response = Contact.class)
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors()
                .stream()
                .map(this::convertAuthorToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Searching Certain author by Author`s ID",
            notes = "Using GET Mapping, method takes the author`s id as PathVariable, and return" +
                    "Author, which has same id as passed",
            response = Contact.class)
    public AuthorDTO getAuthorById(@PathVariable String id) {
        AuthorDTO authorDTO = new AuthorDTO();
        modelMapper.map(authorService.getAuthorById(id), authorDTO);
        return authorDTO;
    }

    @GetMapping("/{firstName}")
    @ApiOperation(value = "Getting Authors by firstName",
            notes = "Using GET Mapping, method takes the author`s firstName as PathVariable, and return" +
                    "List<Author>, which has same firstName as passed",
            response = Contact.class)
    public List<AuthorDTO> getAllAuthorsByFirstName(@PathVariable String firstName) {
        return authorService.getAuthorsByFirstName(firstName)
                .stream()
                .map(this::convertAuthorToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{lastName}")
    @ApiOperation(value = "Getting all Authors by using lastName",
            notes = "Using GET Mapping, method takes the Author`s lastName as PathVariable, and " +
                    "return List<Author> - all the Authors have the same LastName",
            response = Contact.class)
    public List<AuthorDTO> getAllAuthorsByLastName(@PathVariable String lastName) {
        return authorService.getAuthoursByLastName(lastName)
                .stream()
                .map(this::convertAuthorToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    @ApiOperation(value = "Saving Author in the Author Repository",
            notes = "Using POST Mapping, method takes the Author Object in Request Body and save it in the" +
                    "repository",
            response = Contact.class)
    public void addTheAuthor(@RequestBody Author author) {
        authorService.addAuthorToTheBook(author);
    }


    @DeleteMapping("/")
    @ApiOperation(value = "Deleting Author from Repository",
            notes = "Using Delete Mapping, method takes the Author`s in Request Body, find the same " +
                    "object in the repository and drop it out",
            response = Contact.class)
    public void deleteTheAuthorFromRepository(@RequestBody Author author) {
        authorService.deleteAuthor(author);
    }

    @PutMapping("/")
    @ApiOperation(value = "Update Author Information",
            notes = "Using PUT Mapping, method update information about the author has the" +
                    "same id as Author Obeject, which was passed in Request Body",
            response = Contact.class)
    public void updateTheAuthorbyBookId(@RequestBody Author author) {
        authorService.updateAuthor(author);
    }

    public AuthorDTO convertAuthorToDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }
}
