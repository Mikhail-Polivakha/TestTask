package com.TestProject.Test.repository;

import com.TestProject.Test.domain.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
