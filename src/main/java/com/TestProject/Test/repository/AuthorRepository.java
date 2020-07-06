package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, String> {
    public Iterable<Author> findAuthorByFirstName(String firstName);
    public Iterable<Author> findAuthorByLastName(String lastName);
    public Iterable<Author> findByPublishingHouse(List<PublishingHouse> publishingHouses);
    public Iterable<Author> findByGenre(List<Genre> genres);
    public void deleteById(Long id);
}
