package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    public List<Book> findByAuthors(List<Author> authors);
    public List<Book> findByGenres(List<Genre> genres);
    public List<Book> findByPublishingHouses(List<PublishingHouse> publishingHouses);
    public void deleteById(Long id);
}
