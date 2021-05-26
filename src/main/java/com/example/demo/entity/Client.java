package com.example.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "first_name", nullable = true, length = 120)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 120)
    private String lastName;
    @Basic
    @Column(name = "password", nullable = true, length = 120)
    private String password;
    @Basic
    @Column(name = "address", nullable = true, length = 150)
    private String address;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 120)
    private String phoneNumber;

    @OneToMany( mappedBy = "client", cascade = {CascadeType.ALL})
    private Collection<Contract> contracts;

    public Client() {
    }
    public Client(String firstName, String lastName, String password, String address, String phoneNumber) {
    }

   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

      public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Клиент {" +
                "id:" + id +
                ", Имя:" + firstName +
                ", Отчество:" + lastName +
                ", Пароль:" + password +
                ", Адрес:" + address +
                ", Номер телефона:" + phoneNumber +
                '}';
    }
}
