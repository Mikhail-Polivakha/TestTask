package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.dto_layer.GenreDTO;
import com.TestProject.Test.services.GenreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/name{name}")
    @ApiOperation(value = "Searching whole Genres (Notes contains better explanation)",
            notes = "Using GET Mapping, method takes the return List<Genre> exist in DB",
            response = Contact.class)
    public List<GenreDTO> getAllGenres() {
        return genreService.getAllGenres()
                .stream()
                .map(this::convertGenreToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Searching certain genre by genreId",
                notes = "Uisng GET Mapping, method finds certain genre using genreID and return" +
                        "Genre object",
                response = Contact.class)
    public GenreDTO getCertianGenre(@RequestBody Genre genre, @PathVariable int genreID) {
        return modelMapper.map(genreService.getGenre(genre, genreID), GenreDTO.class);
    }

    @DeleteMapping("/{genreId}")
    @ApiOperation(value = "Delete certain genre by genreId",
            notes = "Using Delete Mapping, method finds certain genre using genreID and delete it" +
                    "from repository",
            response = Contact.class)
    public void deleteGenreFromRepositoryById(@PathVariable int genreId) {
        genreService.deleteGenre(genreId);
    }

    @PostMapping("/")
    @ApiOperation(value = "Save certain genre in repository",
            notes = "Using Post Mapping, method takes in Request Body Genre object and save it in the repository",
            response = Contact.class)
    public void saveGenreInRepository(@RequestBody Genre genre) {
        genreService.saveGenre(genre);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update certain genre in repository",
            notes = "Using PUT Mapping, method takes in Request Body Genre object and genreId you want to" +
                    "resave. If passed Genre object exist in repository (finds by ID), method resave it. Ohterwise" +
                    "new Genre object will be created with the same fields, as passed Genre Object",
            response = Contact.class)
    public void updateGenre(@RequestBody Genre genre, int genreId) {
        genreService.updateGenre(genre, genreId);
    }

    private GenreDTO convertGenreToDTO(Genre genre) {
        return modelMapper.map(genre, GenreDTO.class);
    }
}
