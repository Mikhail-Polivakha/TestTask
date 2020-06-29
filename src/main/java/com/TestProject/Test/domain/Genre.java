package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Genre as an object with all required stuff")
public class Genre {

    @Id
    @ApiModelProperty(notes = "Id (as a primary key to access the proper Genre in DB. You should insert" +
            "it manualy, cause it is not incrementing auto)")
    public String id;

    @ApiModelProperty(notes = "Name of the Genre field")
    public String name;

    @ApiModelProperty(notes = "Description of the Genre (Bullshit mostly, but I have to append some field)")
    public String description;
}
