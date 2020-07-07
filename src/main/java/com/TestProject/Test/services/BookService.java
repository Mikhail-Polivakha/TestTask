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
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(String id) throws SourceNotFoundException {
        return bookRepository.findById(String.valueOf(id)).orElse(new Book());
    }

    public void saveBook(Book bookToSave) {
        bookRepository.save(bookToSave);
    }

    public void updateBook(Book updatedBook) {
        bookRepository.save(updatedBook);
    }

    public void deleteBook(long id) throws SourceNotFoundException {
        bookRepository.deleteById(id);
    }

    public List<Book> getBookByAuthors(List<Author> authors) {
        return bookRepository.findByAuthors(authors);
    }

    public List<Book> getBookByGenres(List<Genre> genres) {
        return bookRepository.findByGenres(genres);
    }

    public List<Book> getBookByPublishingHouses(List<PublishingHouse> publishingHouses) {
        return this.bookRepository.findByPublishingHouses(publishingHouses);
    }
}
