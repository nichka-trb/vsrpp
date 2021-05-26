package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @Basic
    @Column(name = "amount_of_days", nullable = true)
    private Integer amountOfDays;

    @Basic
    @Column(name = "cost", nullable = true, precision = 3)
    private BigDecimal cost;

    @Access(AccessType.PROPERTY)
    @ManyToOne(targetEntity = Car.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "car", referencedColumnName = "id")
    private Car car;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "manager", referencedColumnName = "id")
    private Manager manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", date=" + date +
                ", amountOfDays=" + amountOfDays +
                ", cost=" + cost +
                '}';
    }
}
