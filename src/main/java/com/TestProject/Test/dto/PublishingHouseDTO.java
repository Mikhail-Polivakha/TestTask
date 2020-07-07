package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;

import java.util.List;

public class PublishingHouseDTO {

    private List<Book> books;

    private List<Genre> genres;

    private List<Author> authors;

    private String label;

    private String description;
}
