package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class GenreDTO {

    private String name;

    private String description;

    private List<Author> authors;

    private List<PublishingHouse> publishingHouses;

    private List<Book> books;
}
