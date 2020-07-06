package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;

import java.util.List;

public class AuthorDTO {
    private String firstName;
    
    private String lastName;

    private List<GenreDTO> genre;

    private List<PublishingHouseDTO> publishingHouse;

    private List<BookDTO> books;

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


    public List<GenreDTO> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreDTO> genre) {
        this.genre = genre;
    }

    public List<PublishingHouseDTO> getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(List<PublishingHouseDTO> publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
