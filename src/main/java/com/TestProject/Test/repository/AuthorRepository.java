package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, String> {
    public Iterable<Author> findAuthorByFirstName(String firstName);
    public Iterable<Author> findAuthorByLastName(String lastName);
}
