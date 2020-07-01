package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto_layer.PublishingHouseDTO;
import com.TestProject.Test.services.PublishingHouseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishingHouses")
public class PublishingHouseController {

    @Autowired
    PublishingHouseService publishingHouseService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/id{publishingHouseId}")
    @ApiOperation(value = "Searching Publisher House by using the Publishing House`s id",
            notes = "Using GET Mapping, method takes the Publishing House`s id as PathVariable, and return" +
                    "PublishingHouse Object, which has same id as passed",
            response = Contact.class)
    public PublishingHouseDTO getPublishingHouseById(@PathVariable int publishingHouseID) {
        return modelMapper.map(publishingHouseService.getPublishingHouseById(publishingHouseID),
                PublishingHouseDTO.class);
    }

    @GetMapping("/")
    @ApiOperation(value = "Getting whole Publishing Houses from repository",
            notes = "Using GET Mapping, method return List<PublishingHouses> exists in the Repository",
            response = Contact.class)
    public List<PublishingHouseDTO> getAllPublishingHouses() {
        return publishingHouseService.getAllPubishingHouses()
                .stream()
                .map(this::convertPublishingHouseToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    @ApiOperation(value = "Saving Publishing House in the repository",
            notes = "Using POST Mapping, method save PublishingHouse object passed in the RequestBody in the Repository",
            response = Contact.class)
    public void savePublisingHouse(@RequestBody PublishingHouse publishingHouse) {
        publishingHouseService.savePublishingHouseInTheRepository(publishingHouse);
    }

    @PutMapping("/id{publishingHouseId}")
    @ApiOperation(value = "Updating Publishing House in the repository",
            notes = "Using PUT Mapping, method finds PublishingHouse object using id and " +
                    "resave this object using another Publishing House Object passed in the RequestBody. If Publishing House with" +
                    "passed id does not exist in repository, method create a new one object in repository with the same as passed " +
                    "Publishing House fields",
            response = Contact.class)
    public void updatePublihsingHouseByID(@PathVariable int publishingHouseId, @RequestBody PublishingHouse publishingHouse) {
        publishingHouseService.updatePublishingHouseByID(publishingHouse, publishingHouseId);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Deleting Publishing House from the repository",
            notes = "Using Delete Mapping, method takes in Request Body Publishing House as an Object. Method finds in the " +
                    "repository this object and delete it from repository",
            response = Contact.class)
    public void deletePublishingHouse(@RequestBody PublishingHouse publishingHouse) {
        publishingHouseService.deletePublishigHouseFromRepository(publishingHouse);
    }

    private PublishingHouseDTO convertPublishingHouseToDTO(PublishingHouse publishingHouse) {
        return modelMapper.map(publishingHouse, PublishingHouseDTO.class);
    }
}
