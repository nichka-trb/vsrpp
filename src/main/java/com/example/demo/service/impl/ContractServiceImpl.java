package com.example.demo.service.impl;

import com.example.demo.entity.Contract;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Contract getContractByClientAndCar(Long idClient, Long idCar) {
        return contractRepository.findContractByClientAndCar(idClient, idCar);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findContractById(id);
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }
}
