package com.TestProject.Test.services;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishingHouseService {

    @Autowired
    BookRepository bookRepository;

    //TODO: Implement method below to get all books by label of the publishing house

    public List<Book> getAllBooksOfCertainPublishingHouse(String label) {
        return new ArrayList<>();
    }
}
