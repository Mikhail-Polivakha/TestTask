package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Books")
@ApiModel(description = "Book as an object with all required stuff")
public class Book {


    @Id
    @ApiModelProperty(notes = "Id (as a primary key to access the proper book in DB. You should insert " +
            "it manualy, cause it is not incrementing auto)")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany
    @ApiModelProperty(notes = "The author of the book")
    private List<Author> author;

    @ApiModelProperty(notes = "The title of the book, for example 'Garbage Collector Handbook'")
    private String title;

    @ApiModelProperty(notes = "The name of publish House organization (PublishingHouse is an Entity, cause book " +
                    "could have a couple of PublishingHouses)")
    @OneToMany
    private List<PublishingHouse> publishingHouse;

    @ApiModelProperty(notes = "Genre the book was published in (Genre is an Entity, cause book " +
            "could have a couple of Genres)")
    @OneToMany
    private List<Genre> genre;

    public Book(List<Author> author, String title, List<PublishingHouse> publishingHouse, List<Genre> genre) {
        this.author = author;
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.genre = genre;
    }


    public Book() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PublishingHouse> getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(List<PublishingHouse> publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
