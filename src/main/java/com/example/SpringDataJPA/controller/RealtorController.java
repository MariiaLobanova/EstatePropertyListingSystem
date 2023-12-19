package com.example.SpringDataJPA.controller;

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
    public Realtor addRealtor(@RequestBody Realtor realtor){
        return realtorService.createRealtor(realtor);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRealtorById(@PathVariable Long id){
        realtorService.deleteRealtor(id);
    }
    @PutMapping ("/update/{id}")
    public Realtor updateRealtorById(@PathVariable Long id, @RequestParam String email, @RequestParam String phone){
        return realtorService.updateRealtor(id,email,phone);
    }

}
