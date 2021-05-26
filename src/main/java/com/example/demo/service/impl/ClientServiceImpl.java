package com.example.demo.service.impl;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findByName(String firstname) {
        return clientRepository.findClientByFirstName(firstname);
    }
}
