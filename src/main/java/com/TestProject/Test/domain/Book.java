package com.TestProject.Test.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Books")
@ApiModel(description = "Book as an object with all required stuff")
public class Book {


    @Id
    @ApiModelProperty(notes = "Id (as a primary key to access the proper book in DB).")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @ApiModelProperty(notes = "The author of the book")
    private List<Author> authors;

    @ApiModelProperty(notes = "The title of the book, for example 'Garbage Collector Handbook'")
    private String title;

    @ApiModelProperty(notes = "The name of publish House organization (PublishingHouse is an Entity, cause book " +
                    "could have a couple of PublishingHouses)")
    @OneToMany
    private List<PublishingHouse> publishingHouses;

    @ApiModelProperty(notes = "Genre the book was published in (Genre is an Entity, cause book " +
            "could have a couple of Genres)")
    @OneToMany
    private List<Genre> genres;

    public Book(List<Author> authors, String title, List<PublishingHouse> publishingHouses, List<Genre> genres) {
        this.authors = authors;
        this.title = title;
        this.publishingHouses = publishingHouses;
        this.genres = genres;
    }


    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> author) {
        this.authors = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PublishingHouse> getPublishingHouses() {
        return publishingHouses;
    }

    public void setPublishingHouses(List<PublishingHouse> publishingHouse) {
        this.publishingHouses = publishingHouse;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genre) {
        this.genres = genre;
    }
}
