package com.TestProject.Test.services;

import com.TestProject.Test.domain.PublishingHouse;
import com.TestProject.Test.dto.PublishingHouseDTO;
import com.TestProject.Test.repository.PublishingHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublishingHouseService {

    @Autowired
    PublishingHouseRepository publishingHouseRepository;

    @Autowired
    ModelMapper modelMapper;

    public PublishingHouseDTO getPublishingHouseById(long publishingHouseID) {
        return modelMapper.map(publishingHouseRepository.findById(publishingHouseID), PublishingHouseDTO.class);
    }

    public List<PublishingHouseDTO> getAllPublishingHouses() {
        List<PublishingHouse> respond = (List<PublishingHouse>) publishingHouseRepository.findAll();
        return respond.stream().map(this::convertPublishingHouseToDTO).collect(Collectors.toList());
    }

    public void savePublishingHouseInTheRepository(PublishingHouseDTO publishingHouse) {
        publishingHouseRepository.save(modelMapper.map(publishingHouse, PublishingHouse.class));
    }

    public void updatePublishingHouse(PublishingHouseDTO publishingHouse) {
        publishingHouseRepository.save(modelMapper.map(publishingHouse, PublishingHouse.class));
    }

    public void deletePublishingHouseFromRepository(long id) {
        publishingHouseRepository.deleteById(id);
    }

    private PublishingHouseDTO convertPublishingHouseToDTO(PublishingHouse publishingHouse) {
        return modelMapper.map(publishingHouse, PublishingHouseDTO.class);
    }
}
