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

    @ManyToMany
    private List<Genre> genre;

    @ManyToMany
    private List<PublishingHouse> publishingHouse;

    @ManyToMany
    private List<Book> books;

    public Author(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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
