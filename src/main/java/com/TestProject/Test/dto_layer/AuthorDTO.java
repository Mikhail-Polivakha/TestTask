package com.TestProject.Test.dto_layer;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class AuthorDTO {
    private String firstName;
    
    private String lastName;

    private List<Genre> genre;

    private List<PublishingHouse> publishingHouse;

    private List<Book> books;
}
