package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.model.Realtor;
import com.example.SpringDataJPA.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository) {
        this.realtorRepository = realtorRepository;
    }
    public List<Realtor> getAllRealtor() {
        return realtorRepository.findAll();
    }

    public Optional<Realtor> getRealtor(Long id){
        return realtorRepository.findById(id);
    }
    public Realtor createRealtor(Realtor realtor){
        return realtorRepository.save(realtor);
    }



}
