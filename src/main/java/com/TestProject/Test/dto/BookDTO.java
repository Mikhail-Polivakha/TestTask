package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class BookDTO {

    private Long id;

    private String title;

    private List<Long> authorsId;
    
    private List<String> authorsNames;
    
    private List<String> authorLastnames;

    private List<String> genreNames;
    
    private List<Long> genreId;
    
    private List<String> publishingHouseTitle;
    
    private List<Long> publishingHouseId;
}
