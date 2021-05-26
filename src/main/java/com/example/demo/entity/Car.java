package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "model", nullable = true, length = 120)
    private String model;
    @Basic
    @Column(name = "color", nullable = true, length = 120)
    private String color;
    @Basic
    @Column(name = "price", nullable = true, precision = 3)
    private Integer price;

    @Basic
    @Column(name = "availability", nullable = true)
    private Integer availability;

    @OneToMany(targetEntity = Contract.class, mappedBy = "car", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Collection<Contract> contracts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "id " + id +
                ", model " + model +
                ", color " + color +
                ", price " + price +
                ", availability " + availability;
    }

}
