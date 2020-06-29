package com.TestProject.Test.Repository;

import com.TestProject.Test.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
