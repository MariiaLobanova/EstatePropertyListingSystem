package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    public Optional <Property> getProperty(Long id){
        return propertyRepository.findById(id);
    }
    public Property createProperty(Property property){
        return propertyRepository.save(property);
    }


}
