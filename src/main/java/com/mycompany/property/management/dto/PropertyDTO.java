package com.mycompany.property.management.dto;

import lombok.Data;

@Data
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;

    public Long getId() {
        return id;
    }

    public PropertyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PropertyDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PropertyDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public PropertyDTO setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public PropertyDTO setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public PropertyDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PropertyDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
