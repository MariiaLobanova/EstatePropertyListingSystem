package com.example.SpringDataJPA.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="properties")

public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String type;
    private double price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    //private String listingDate;

    @ManyToOne
    @JoinColumn(name = "realtorId", referencedColumnName = "id")
    private Realtor realtor;

    public Property() {
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    /*public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }
*/
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
