package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto.AuthorDTO;
import com.TestProject.Test.dto.GenreDTO;
import com.TestProject.Test.dto.PublishingHouseDTO;
import com.TestProject.Test.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<GenreDTO> getAllGenres() {
        List<Genre> respond = (List<Genre>) genreRepository.findAll();
        return respond.stream().map(this::convertGenreToDTO).collect(Collectors.toList());
    }

    public GenreDTO getGenre(long genreID) {
        return modelMapper.map(genreRepository.findById(genreID), GenreDTO.class);
    }

    public void deleteGenre(int genreId) {
        genreRepository.deleteById(genreId);
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public List<GenreDTO> getGenresByPublishingHouses(List<PublishingHouseDTO> publishingHouses) {

        List<Genre> respond =  (List<Genre>) genreRepository.findByPublishingHouses(
                publishingHouses.stream().map(publishingHouseDTO -> modelMapper.map(
                        publishingHouseDTO, PublishingHouse.class
                )).collect(Collectors.toList())
        );

        return respond.stream().map(this::convertGenreToDTO).collect(Collectors.toList());
    }

    public List<GenreDTO> getGenreByAuthor(List<AuthorDTO> authors) {
        List<Genre> respond = (List<Genre>) genreRepository.findByAuthors(
                authors.stream().map(authorDTO -> modelMapper.map(authorDTO, Author.class))
                .collect(Collectors.toList())
        );

        return respond.stream().map(this::convertGenreToDTO).collect(Collectors.toList());
    }

    private GenreDTO convertGenreToDTO(Genre genre) {
        return modelMapper.map(genre, GenreDTO.class);
    }

}
