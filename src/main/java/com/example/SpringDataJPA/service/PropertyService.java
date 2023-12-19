package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.model.Realtor;
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
    public Property createProperty(Property property, Long realtorId){
        Realtor realtor = new Realtor();
        realtor.setId(realtorId);
        property.setRealtor(realtor);
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id){
        propertyRepository.deleteById(id);
    }

    public Property updateProperty(Long id, double price){
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        Property property = optionalProperty.get();
        property.setPrice(price);
        return propertyRepository.save(property);
    }


}
