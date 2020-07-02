package com.TestProject.Test.dto_layer;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;

import java.util.List;

public class PublishingHouseDTO {

    private List<BookDTO> books;

    private List<GenreDTO> genres;

    private List<AuthorDTO> authors;

    private String label;

    private String description;
}
