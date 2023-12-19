package com.example.SpringDataJPA.model;
import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;

// as id, name, email, and phone.
@Entity
@Table(name = "realtors")
@Validated
public class Realtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "realtor", cascade = CascadeType.ALL)
    private List<Property> properties;

    public Realtor(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Realtor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
