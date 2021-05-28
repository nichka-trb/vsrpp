package com.example.demo.repository;

import com.example.demo.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findContractById(Long id);

    Contract findContractByClientAndCar(Long idClient, Long idCar);

}
