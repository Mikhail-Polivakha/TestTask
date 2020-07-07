package com.TestProject.Test.services;

import com.TestProject.Test.domain.Author;
import com.TestProject.Test.domain.Genre;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto.AuthorDTO;
import com.TestProject.Test.dto.BookDTO;
import com.TestProject.Test.dto.GenreDTO;
import com.TestProject.Test.dto.PublishingHouseDTO;
import com.TestProject.Test.exceptions.SourceNotFoundException;
import com.TestProject.Test.repository.BookRepository;
import com.TestProject.Test.domain.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<BookDTO> getAllBooks() {
        List<Book> respond = (List<Book>) bookRepository.findAll();
        return respond.stream().map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(long id) {
        return modelMapper.map(bookRepository.findById(String.valueOf(id)).orElse(new Book()), BookDTO.class);
    }

    public void saveBook(BookDTO bookToSave) {
        bookRepository.save(modelMapper.map(bookToSave, Book.class));
    }

    public void updateBook(BookDTO updatedBook) {
        bookRepository.save(modelMapper.map(updatedBook, Book.class));
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public List<BookDTO> getBookByAuthors(List<AuthorDTO> authors) {

        List<Book> respond = bookRepository.findByAuthors(
                authors.stream().map(authorDTO -> modelMapper.map(authorDTO, Author.class))
                .collect(Collectors.toList())
        );

        return respond.stream().map(this::convertBookToDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getBookByGenres(List<GenreDTO> genres) {
        List<Book> respond = bookRepository.findByGenres(
                genres.stream().map(genreDTO -> modelMapper.map(genreDTO, Genre.class))
                .collect(Collectors.toList())
        );

        return respond.stream().map(this::convertBookToDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getBookByPublishingHouses(List<PublishingHouseDTO> publishingHouses) {
        List<Book> respond = bookRepository.findByPublishingHouses(
                publishingHouses.stream().map(publishingHouseDTO ->
                        modelMapper.map(publishingHouseDTO, PublishingHouse.class))
                .collect(Collectors.toList())
        );

        return respond.stream().map(this::convertBookToDTO).collect(Collectors.toList());
    }

    private BookDTO convertBookToDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

}
