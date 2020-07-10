package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class GenreDTO {

    private Long id;

    private String name;

    private String description;

    private List<Long> authorsId;
    
    private List<String> authorsNames;
    
    private List<String> authorLastnames;
    
    private List<String> publishingHouseTitle;
    
    private List<Long> publishingHouseId;
    
    private List<String> bookTitles;

    private List<Long> booksId;
}
