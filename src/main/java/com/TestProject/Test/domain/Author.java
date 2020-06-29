package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Author as an object with all required stuff")
public class Author {

    @Id
    @ApiModelProperty(notes = "Id (Primary key od th certain Author). You have to insert it manually")
    private String id;

    @ApiModelProperty(notes = "FirstName of the author")
    private String FirstName;

    @ApiModelProperty(notes = "LastName of the author")
    private String LastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    public Author() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
