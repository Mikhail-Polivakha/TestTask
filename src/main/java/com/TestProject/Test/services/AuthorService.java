package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Book;
import com.TestProject.Test.repository.AuthorRepository;
import com.TestProject.Test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooksClaimedToAuthorById(String id) {
        return new ArrayList<>();
    }

    public List<Book> getAllBooksClaimedToAuthorByFirstName(String firstName) {
        return new ArrayList<>();
    }

    public List<Book> getAllBooksClaimedToAuthorByLastName(String lastName) {
        return new ArrayList<>();
    }

    public void addAuthorToTheBook(Author author, String bookID) {
        //TODO: Implment this method allows us to append passed author to book with id equals as passed
    }

    public void deleteAuthor(String bookID, String authorId) {
        //TODO: Implment this method allows us to delete passed author has the smae id as passed
        // from the book with id equals as passed
    }

    public void updateAuthor(String bookId, Author author) {
        //TODO: Implment this method allows us to update passed author in book, which has id equals as passed
    }
}
