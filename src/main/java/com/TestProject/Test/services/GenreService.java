package com.TestProject.Test.services;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    BookRepository bookRepository;

    //TODO: Implement the method below. Expected behavior: methods return all books published in certain genre

    public List<Book> getAllBooksPublishedInGenre(String name) {
        return new ArrayList<>();
    }

    public void saveGenre(Genre genre, String bookId) {
        //TODO: Implement the method allow to save genre in some book`s Genre list
    }
}
