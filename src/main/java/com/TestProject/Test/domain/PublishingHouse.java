package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Publishing House as an object with all required stuff")
public class PublishingHouse {

    @Id
    @ApiModelProperty(notes = "Id - primary key to access the proper PublishingHouse in DB. You should insert" +
            "it manualy, cause it is not incrementing auto")
    private String id;

    @ApiModelProperty(notes = "Label of the PublishingHouse")
    private String label;

    @ApiModelProperty(notes = "Description of the Genre (Bullshit mostly, but I have to append some field)")
    private String description;

    public PublishingHouse() {
    }

    public PublishingHouse(String id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
