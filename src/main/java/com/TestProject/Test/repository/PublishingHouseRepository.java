package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Integer> {
    public Iterable<PublishingHouse> findByLabel(String label);
    public Iterable<PublishingHouse> findByAuthors(List<Author> authors);
    public Iterable<PublishingHouse> findByGenres(List<Genre> genres);
}
