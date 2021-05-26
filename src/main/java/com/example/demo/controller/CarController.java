package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Qualifier("carServiceImpl")
    @Autowired
    GeneralService generalService;

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getClient(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Car car = (Car) this.generalService.findById(id);

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        HttpHeaders headers = new HttpHeaders();
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.generalService.save(car);
        return new ResponseEntity<>(car, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> deleteClient(@PathVariable("id") Long id) {
        Car car = (Car) this.generalService.findById(id);

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.generalService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>>getAllClients() {
        List<Car> cars = this.generalService.findAll();

        if (cars.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


}
