package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

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

    public List<Genre> getGenresByPublishingHouses(List<PublishingHouse> publishingHouses) {
        return (List<Genre>) genreRepository.findByPublishingHouses(publishingHouses);
    }

    public List<Genre> getGenreByAuthor(List<Author> authors) {
        return (List<Genre>) genreRepository.findByAuthors(authors);
    }
}
