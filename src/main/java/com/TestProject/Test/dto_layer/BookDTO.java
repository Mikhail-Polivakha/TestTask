package com.TestProject.Test.dto_layer;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class BookDTO {

    private String title;

    private List<AuthorDTO> authors;

    private List<GenreDTO> genres;

    private List<PublishingHouseDTO> publishingHouses;
}
