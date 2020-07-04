package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.repository.AuthorRepository;
import com.TestProject.Test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author getAuthorById(String id) {
        return authorRepository.findById(id).orElse(new Author());
    }

    public void addAuthorToTheBook(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAuthorsByFirstName(String firstName) {
        return (List<Author>) authorRepository.findAuthorByFirstName(firstName);
    }

    public List<Author> getAuthoursByLastName(String lastName) {
        return (List<Author>) authorRepository.findAuthorByLastName(lastName);
    }

    public List<Author> getAuthorsByPublishingHouses(List<PublishingHouse> publishingHouses) {
        return (List<Author>) authorRepository.findByPublishingHouse(publishingHouses);
    }

    public List<Author> getAuthorsByGenres(List<Genre> genres) {
        return (List<Author>) authorRepository.findByGenre(genres);
    }
}
