package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
