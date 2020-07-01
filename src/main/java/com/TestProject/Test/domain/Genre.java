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

    @ManyToMany
    private List<Author> authors;

    @ManyToMany
    private List<PublishingHouse> publishingHouses;

    @ManyToMany
    private List<Book> books;
}
