package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.model.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor, Long> {
}
