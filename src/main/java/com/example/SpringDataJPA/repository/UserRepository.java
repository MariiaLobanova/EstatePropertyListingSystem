package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.model.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
