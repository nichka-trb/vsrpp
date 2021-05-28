package com.example.demo.service;

import com.example.demo.entity.Contract;

public interface ContractService extends GeneralService<Contract> {
    Contract getContractByClientAndCar(Long idClient, Long idCar);
}
