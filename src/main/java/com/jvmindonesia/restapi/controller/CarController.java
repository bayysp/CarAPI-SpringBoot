package com.jvmindonesia.restapi.controller;

import com.jvmindonesia.restapi.domain.Car;
import com.jvmindonesia.restapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired //langsung menggunakan fitur yang extends oleh CarRepository
    private CarRepository carRepository;

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable("id") String id){
        return carRepository.findById(Long.parseLong(id));
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable("id") Long id){
        carRepository.deleteById(id);
    }

    //get mapping fitur baru
    @GetMapping("/cars/filter")
    public List<Car> getCarByBrand(@RequestParam("brand") String brand){
        return carRepository.findByBrand(brand);
    }

    @GetMapping("/cars/filter")
    public List<Car> getCarByModel(@RequestParam("brand") String model){return carRepository.findByModel(model);}


    @PostMapping("/cars")
    public ResponseEntity<Car> addNewCar(@RequestBody Car car){
        Car carResponse = carRepository.save(car);
        return new ResponseEntity<>(carResponse, HttpStatus.OK);
    }
}
