package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel(description = "Publishing House as an object with all required stuff")
public class PublishingHouse {

    @Id
    @ApiModelProperty(notes = "Id - primary key to access the proper PublishingHouse in DB")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "Label of the PublishingHouse")
    private String label;

    @ApiModelProperty(notes = "Description of the Genre (Bullshit mostly, but I have to append some field)")
    private String description;

    @ManyToMany
    private List<Genre> genres;

    @ManyToMany
    private List<Author> authors;

    @ManyToMany
    private List<Book> books;

    public PublishingHouse() {
    }

    public PublishingHouse(Long id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
