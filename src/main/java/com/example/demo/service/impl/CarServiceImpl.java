package com.example.demo.service.impl;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements GeneralService<Car> {

    @Autowired
    CarRepository carRepository;

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findCarById(id);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

}
