package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@ApiModel(description = "Author as an object with all required stuff")
public class Author {

    @Id
    @ApiModelProperty(notes = "Id (Primary key od th certain Author)")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "FirstName of the author")
    private String firstName;

    @ApiModelProperty(notes = "LastName of the author")
    private String lastName;

    @OneToMany
    private List<String> genreNames;
    
    @OneToMany
    private List<Long> genreId;
        
    @OneToMany
    private List<String> bookTitles;

    @OneToMany
    private List<Long> booksId;
    
    @OneToMany
    private List<String> publishingHouseTitle;
    
    @OneToMany
    private List<Long> publishingHouseId;

    public Author() {
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
