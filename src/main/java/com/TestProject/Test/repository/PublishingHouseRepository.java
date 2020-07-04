package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Integer> {
    public List<Iterable> findByLabel(String label);
    public List<Iterable> findByAuthors(List<Author> authors);
    public List<Iterable> findByGenres(List<Genre> genres);
}
