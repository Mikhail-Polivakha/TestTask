package com.TestProject.Test.dto_layer;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class GenreDTO {

    private String name;

    private String description;

    private List<AuthorDTO> authors;

    private List<PublishingHouseDTO> publishingHouses;

    private List<BookDTO> books;
}
