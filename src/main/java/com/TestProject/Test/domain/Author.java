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
    private String firstName;

    @ApiModelProperty(notes = "LastName of the author")
    private String lastName;

    public Author(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
