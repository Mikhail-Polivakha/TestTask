package com.TestProject.Test.services;

import com.TestProject.Test.domain.Book;
import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.repository.BookRepository;
import com.TestProject.Test.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishingHouseService {

    @Autowired
    PublishingHouseRepository publishingHouseRepository;

    //TODO: Implement method below to get all books by label of the publishing house

    public PublishingHouse getPublishingHouseById(int publishingHouseID) {
        return publishingHouseRepository.findById(publishingHouseID).orElse(new PublishingHouse());
    }

    public List<PublishingHouse> getAllPubishingHouses() {
        return (List<PublishingHouse>) publishingHouseRepository.findAll();
    }

    public void savePublishingHouseInTheRepository(PublishingHouse publishingHouse) {
        publishingHouseRepository.save(publishingHouse);
    }

    public void updatePublishingHouseByID(PublishingHouse publishingHouse, int publishingHouseId) {
        publishingHouseRepository.save(publishingHouseRepository.findById(publishingHouseId).orElse(new PublishingHouse()));
    }

    public void deletePublishigHouseFromRepository(PublishingHouse publishingHouse) {
        publishingHouseRepository.delete(publishingHouse);
    }
}
