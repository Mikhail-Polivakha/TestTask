package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    public Iterable<Genre> findByPublishingHouses(List<PublishingHouse> publishingHouses);
    public Iterable<Genre> findByAuthors(List<Author> authors);
}
