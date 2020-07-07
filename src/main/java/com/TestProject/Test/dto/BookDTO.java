package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class BookDTO {

    private Long id;

    private String title;

    private List<Author> authors;

    private List<Genre> genres;

    private List<PublishingHouse> publishingHouses;
}
