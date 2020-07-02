package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.exceptions.SourceNotFoundException;
import com.TestProject.Test.repository.BookRepository;
import com.TestProject.Test.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(String id) throws SourceNotFoundException {
        return this.bookRepository.findById(String.valueOf(id)).orElse(new Book());
    }

    public void saveBook(Book bookToSave) {
        this.bookRepository.save(bookToSave);
    }

    public void updateBook(Book updatedBook) {
        this.bookRepository.save(updatedBook);
    }

    public void deleteBook(Book bookToDelete) throws SourceNotFoundException {
        this.bookRepository.delete(bookToDelete);
    }

    public Book getBookByAuthors(List<Author> authors) {
        return this.bookRepository.findByAuthors(authors);
    }

    public Book getBookByGenres(List<Genre> genres) {
        return this.bookRepository.findByGenres(genres);
    }

    public Book getBookByPublishingHouses(List<PublishingHouse> publishingHouses) {
        return this.bookRepository.findByPublishingHouses(publishingHouses);
    }
}
