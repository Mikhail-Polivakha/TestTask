package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, String> {

}
