package com.TestProject.Test.services;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.repository.BookRepository;
import com.TestProject.Test.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    //TODO: Implement the method below. Expected behavior: methods return all books published in certain genre

    public List<Genre> getAllGenres() {
        return (List<Genre>) genreRepository.findAll();
    }

    public Genre getGenre(Genre genre, int genreID) {
        return genreRepository.findById(genreID).orElse(new Genre());
    }

    public void deleteGenre(int genreId) {
        genreRepository.deleteById(genreId);
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre genre, int genreId) {
        genreRepository.save(genreRepository.findById(genreId).orElse(new Genre()));
    }
}
