package com.example.SpringDataJPA;

import com.example.SpringDataJPA.controller.PropertyController;
import com.example.SpringDataJPA.model.Property;
import com.example.SpringDataJPA.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropertyController.class)
@AutoConfigureMockMvc(addFilters = false)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyService propertyService;

    @Test
    void propertyShouldReturnMessageFromService() throws Exception {
        Property sampleProperty = new Property();
        when(propertyService.getAllProperty()).thenReturn(Collections.singletonList(sampleProperty));

        this.mockMvc.perform(get("/properties"))
                .andExpect(status().isOk());
    }

}
