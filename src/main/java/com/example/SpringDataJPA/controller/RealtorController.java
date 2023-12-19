package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.model.Realtor;
import com.example.SpringDataJPA.service.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realtors")
public class RealtorController {

    @Autowired
    private RealtorService realtorService;

    @GetMapping
    public List<Realtor> getAllRealtor(){
        return realtorService.getAllRealtor();
    }

    @GetMapping("/{id}")
    public Optional<Realtor> getRealtorById(@PathVariable Long id){
        return realtorService.getRealtor(id);
    }
    @PostMapping("/add")
    public Realtor addPRealtor(@RequestBody Realtor realtor){
        return realtorService.createRealtor(realtor);
    }
}
