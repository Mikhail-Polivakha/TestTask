package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
    public Iterable<Genre> findByPublishingHouses(List<PublishingHouse> publishingHouses);
    public Iterable<Genre> findByAuthors(List<Author> authors);
}
