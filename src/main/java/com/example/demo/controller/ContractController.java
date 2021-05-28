package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.entity.Contract;
import com.example.demo.service.ClientService;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ContractController {

    @Qualifier("contractServiceImpl")
    @Autowired
    ContractService contractService;

    @Qualifier("clientServiceImpl")
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "contract/{idClient}/{idCar}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getContractClientByCar(@PathVariable("idClient") Long idClient,
                                                           @PathVariable("idCar") Long idCar) {
        if (idClient == null || idCar == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Contract> contracts = this.contractService.findAll();
        List<Client> clients = new ArrayList<>();
        List<Contract> stepContracts = new ArrayList<>();

        for (Contract contract: contracts) {
            if (contract.getClient().getId().equals(idClient)) {
                stepContracts.add(contract);
            }
        }
        for (Contract newContract: stepContracts) {
            if ((newContract.getCar().getId().equals(idCar)) &&
                    !(clients.contains(clientService.findById(newContract.getClient().getId())))) {
                clients.add(clientService.findById(newContract.getClient().getId()));
            }
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
