package com.TestProject.Test.controllers;

import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto.PublishingHouseDTO;
import com.TestProject.Test.services.PublishingHouseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishingHouses")
public class PublishingHouseController {

    @Autowired
    PublishingHouseService publishingHouseService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/id/{publishingHouseId}")
    @ApiOperation(value = "Searching Publisher House by using the Publishing House`s id",
            notes = "Using GET Mapping, method takes the Publishing House`s id as PathVariable, and return" +
                    "PublishingHouse Object, which has same id as passed",
            response = Contact.class)
    public PublishingHouseDTO getPublishingHouseById(@PathVariable int publishingHouseId) {
        return publishingHouseService.getPublishingHouseById(publishingHouseId);
    }

    @GetMapping("/")
    @ApiOperation(value = "Getting whole Publishing Houses from repository",
            notes = "Using GET Mapping, method return List<PublishingHouses> exists in the Repository",
            response = Contact.class)
    public List<PublishingHouseDTO> getAllPublishingHouses() {
        return publishingHouseService.getAllPublishingHouses();
    }

    @PostMapping("/")
    @ApiOperation(value = "Saving Publishing House in the repository",
            notes = "Using POST Mapping, method save PublishingHouse object passed in the RequestBody in the Repository",
            response = Contact.class)
    public void savePublisingHouse(@RequestBody PublishingHouseDTO publishingHouse) {
        publishingHouseService.savePublishingHouseInTheRepository(publishingHouse);
    }

    @PutMapping("/")
    @ApiOperation(value = "Updating Publishing House in the repository",
            notes = "Using PUT Mapping, method finds PublishingHouse object and resave this object using another Publishing House Object passed in the RequestBody. If Publishing House with" +
                    "passed id does not exist in repository, method create a new one object in repository with the same as passed " +
                    "Publishing House fields",
            response = Contact.class)
    public void updatePublihsingHouse(@RequestBody PublishingHouseDTO publishingHouse) {
        publishingHouseService.updatePublishingHouse(publishingHouse);
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Deleting Publishing House from the repository",
            notes = "Using Delete Mapping, method takes as parameter id of publishingHouse you want to delete." +
                    " Method finds in the repository this object using passed id and delete it from repository",
            response = Contact.class)
    public void deletePublishingHouse(@PathVariable long id) {
        publishingHouseService.deletePublishingHouseFromRepository(id);
    }

    private PublishingHouseDTO convertPublishingHouseToDTO(PublishingHouse publishingHouse) {
        return modelMapper.map(publishingHouse, PublishingHouseDTO.class);
    }
}
