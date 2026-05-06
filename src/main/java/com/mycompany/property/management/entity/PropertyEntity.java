package com.mycompany.property.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "PROPERTY_TABLE")

@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private Double price;
    private String address;

    public Long getId() {
        return id;
    }

    public PropertyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PropertyEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PropertyEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public PropertyEntity setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PropertyEntity setAddress(String address) {
        this.address = address;
        return this;
    }
}
