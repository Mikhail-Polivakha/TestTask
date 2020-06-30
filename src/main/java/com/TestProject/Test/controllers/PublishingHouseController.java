package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PublishingHouse")
public class PublishingHouseController {

    @Autowired
    PublishingHouseService publishingHouseService;

    @GetMapping("/label{label}")
    public List<Book> getAllBooksByPublishingHouseLabel(@PathVariable String label) {
        return publishingHouseService.getAllBooksOfCertainPublishingHouse(label);
    }
}
