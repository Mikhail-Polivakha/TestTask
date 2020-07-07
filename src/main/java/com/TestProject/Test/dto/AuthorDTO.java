package com.TestProject.Test.dto;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;

import java.util.List;

public class AuthorDTO {

    private Long id;

    private String firstName;
    
    private String lastName;

    private List<Genre> genre;

    private List<PublishingHouse> publishingHouse;

    private List<Book> books;

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


    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<PublishingHouse> getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(List<PublishingHouse> publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
