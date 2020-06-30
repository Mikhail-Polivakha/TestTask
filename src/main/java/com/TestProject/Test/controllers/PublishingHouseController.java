package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.services.PublishingHouseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
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
    @ApiOperation(value = "Searching whole books published by some Publisher House by using the Publishing House`s label",
            notes = "Using GET Mapping, method takes the Publishing House`s label as PathVariable, and return" +
                    "List<Books> published by Publisher House, which has same label as passed",
            response = Contact.class)
    public List<Book> getAllBooksByPublishingHouseLabel(@PathVariable String label) {
        return publishingHouseService.getAllBooksOfCertainPublishingHouse(label);
    }
}
