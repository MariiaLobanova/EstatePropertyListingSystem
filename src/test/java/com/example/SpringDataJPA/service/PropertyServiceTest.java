package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyService propertyService;
    private Property property;

    @Test
    void getAllPropertyShouldReturnListOfProperties() {
        when(propertyRepository.findAll()).thenReturn(Arrays.asList(new Property(),new Property()));
        List<Property> propertyList = propertyService.getAllProperty();
        assertThat(propertyList).hasSize(2);
    }

    @Test
    void getPropertyWithValidId() {
        Long propertyId = 1L;
        Property property1 = new Property();
        when(propertyRepository.findById(propertyId)).thenReturn(Optional.of(property1));
        Optional<Property> result = propertyService.getProperty(propertyId);
        assertThat(result).isPresent().contains(property1);
    }
    @Test
    void createPropertyShouldCreateAndReturnProperty() {
        Property property = new Property();
        Long realtorId = 1L;
        when(propertyRepository.save(any(Property.class))).thenReturn(property);
        Property result = propertyService.createProperty(property, realtorId);
        assertThat(result).isEqualTo(property);
    }

    @Test
    void deleteProperty_withValidId_shouldDeleteProperty() {
        Long propertyId = 1L;
        propertyService.deleteProperty(propertyId);
        verify(propertyRepository, times(1)).deleteById(propertyId);
    }

    @Test
    void updateProperty_withValidId_shouldUpdateAndReturnProperty() {
        Long propertyId = 1L;
        double newPrice = 150000.0;
        Property existingProperty = new Property();
        existingProperty.setId(propertyId);

        when(propertyRepository.findById(propertyId)).thenReturn(Optional.of(existingProperty));
        when(propertyRepository.save(any(Property.class))).thenReturn(existingProperty);

        Property result = propertyService.updateProperty(propertyId, newPrice);

        assertThat(result.getPrice()).isEqualTo(newPrice);
    }

}