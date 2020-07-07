package com.TestProject.Test.services;

import com.TestProject.Test.controllers.AuthorController;
import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto.AuthorDTO;
import com.TestProject.Test.dto.GenreDTO;
import com.TestProject.Test.dto.PublishingHouseDTO;
import com.TestProject.Test.repository.AuthorRepository;
import com.TestProject.Test.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AuthorDTO> getAllAuthors() {
        List<Author> respond = (List<Author>) authorRepository.findAll();
        return respond.stream().map(this::convertAuthorToDTO).collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(long id) {
        Author respond = authorRepository.findById(String.valueOf(id)).orElse(new Author());
        return modelMapper.map(respond, AuthorDTO.class);
    }

    public void addAuthorToTheBook(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<AuthorDTO> getAuthorsByFirstName(String firstName) {
        List<Author> response = (List<Author>) authorRepository.findAuthorByFirstName(firstName);
        return response.stream().map(this::convertAuthorToDTO).collect(Collectors.toList());
    }

    public List<AuthorDTO> getAuthoursByLastName(String lastName) {
        List<Author> response = (List<Author>) authorRepository.findAuthorByLastName(lastName);
        return response.stream().map(this::convertAuthorToDTO).collect(Collectors.toList());
    }

    public List<AuthorDTO> getAuthorsByPublishingHouses(List<PublishingHouseDTO> publishingHouses) {

        List<PublishingHouse> publishingHousesToPassAsEntity =  publishingHouses.stream().map(
                        publishingHouseDTO -> modelMapper.map(publishingHouseDTO, PublishingHouse.class)
                ).collect(Collectors.toList());

        List<Author> response = (List<Author>) authorRepository
                .findByPublishingHouse(publishingHousesToPassAsEntity);

        return response.stream().map(this::convertAuthorToDTO).collect(Collectors.toList());
    }

    public List<AuthorDTO> getAuthorsByGenres(List<GenreDTO> genres) {

        List<Genre> genresToPassAsEntity = genres.stream().map(
                genreDTO -> modelMapper.map(genreDTO, Genre.class)
        ).collect(Collectors.toList());

        List<Author> reponse = (List<Author>) authorRepository.findByGenre(genresToPassAsEntity);
        return reponse.stream().map(this::convertAuthorToDTO).collect(Collectors.toList());
    }

    public AuthorDTO convertAuthorToDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

}
