package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class AuthorDTO {

    private Long id;

    private String firstName;
    
    private String lastName;

    private List<String> genreNames;
    
    private List<Long> genreId;
        
    private List<String> bookTitles;

    private List<Long> booksId;
    
    private List<String> publishingHouseTitle;
    
    private List<Long> publishingHouseId;


}
