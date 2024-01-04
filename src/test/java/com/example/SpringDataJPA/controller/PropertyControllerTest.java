package com.example.SpringDataJPA.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyControllerTest {

    @Autowired
    private PropertyController propertyController;

    @Test
    void contextLoads(){
        assertThat(propertyController).isNotNull();
    }

}