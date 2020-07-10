package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;

import java.util.List;

public class PublishingHouseDTO {

    private Long id;

    private List<String> bookTitles;

    private List<Long> booksId;
    
    private List<String> genreNames;
    
    private List<Long> genreId;
    
    private List<Long> authorsId;
    
    private List<String> authorsNames;
    
    private List<String> authorLastnames;
    
    private String label;

    private String description;
}
