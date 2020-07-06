package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    public Book findByAuthors(List<Author> authors);
    public Book findByGenres(List<Genre> genres);
    public Book findByPublishingHouses(List<PublishingHouse> publishingHouses);
    public void deleteById(Long id);
}
