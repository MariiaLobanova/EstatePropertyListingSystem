package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property,Long> {

    @Query("SELECT p FROM Property p INNER JOIN p.realtor r WHERE r.id = :realtorId")
    List<Property> findByRealtorId(@Param("realtorId") Long realtorId);


}

