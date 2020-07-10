package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel(description = "Genre as an object with all required stuff")
public class Genre {

    @Id
    @ApiModelProperty(notes = "Id (as a primary key to access the proper Genre in DB. You should insert")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @ApiModelProperty(notes = "Name of the Genre field")
    public String name;

    @ApiModelProperty(notes = "Description of the Genre (Bullshit mostly, but I have to append some field)")
    public String description;

    @OneToMany
    private List<Long> authorsId;
    
    @OneToMany
    private List<String> authorsNames;
    
    @OneToMany
    private List<String> authorLastnames;
    
    @OneToMany
    private List<String> publishingHouseTitle;
    
    @OneToMany
    private List<Long> publishingHouseId;

    @OneToMany
    private List<String> bookTitles;
    
    @OneToMany
    private List<Long> booksId;
}
