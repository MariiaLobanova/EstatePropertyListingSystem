package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getAllProperty(){
        return propertyService.getAllProperty();
    }

    @GetMapping("/{id}")
    public Optional <Property> getPropertyById(@PathVariable Long id){
        return propertyService.getProperty(id);
    }
    @PostMapping("/add")
    public Property addProperty(@RequestBody Property property){
        return propertyService.createProperty(property);
    }


}
