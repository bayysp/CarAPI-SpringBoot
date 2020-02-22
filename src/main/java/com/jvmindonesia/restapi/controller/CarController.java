package com.jvmindonesia.restapi.controller;

import com.jvmindonesia.restapi.domain.Car;
import com.jvmindonesia.restapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired //langsung menggunakan fitur yang extends oleh CarRepository
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable("id") String id){
        return carRepository.findById(Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carRepository.deleteById(id);
    }

    //masih error
    @GetMapping
    public List<Car> getCarByBrand(@Param("brand") String brand){
        return carRepository.findByBrand(brand);
    }

    @PostMapping
    public Car addNewCar(@RequestBody Car car){
        return carRepository.save(car);
    }
}
