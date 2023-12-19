package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property,Long> {


}

