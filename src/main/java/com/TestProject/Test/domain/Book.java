package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Books")
@ApiModel(description = "Book as an object with all required stuff")
public class Book {


    @Id
    @ApiModelProperty(notes = "Id (as a primary key to access the proper book in DB).")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "The title of the book, for example 'Garbage Collector Handbook'")
    private String title;

    @OneToMany
    private List<Long> authorsId;
    
    @OneToMany
    private List<String> authorsNames;

    @OneToMany
    private List<String> authorLastnames;

    @OneToMany
    private List<String> genreNames;
    
    @OneToMany
    private List<Long> genreId;
    
    @OneToMany
    private List<String> publishingHouseTitle;
    
    @OneToMany
    private List<Long> publishingHouseId;

    public Book() {

    }
}
