package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Integer> {
    public Iterable<PublishingHouse> findByLabel(String label);
    public Iterable<PublishingHouse> findByAuthors(List<Author> authors);
    public Iterable<PublishingHouse> findByGenres(List<Genre> genres);
    public void deleteById(long id);
}
