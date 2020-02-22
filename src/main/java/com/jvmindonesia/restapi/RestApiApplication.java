package com.jvmindonesia.restapi;

import com.jvmindonesia.restapi.domain.Car;
import com.jvmindonesia.restapi.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CarRepository carRepository) {
        return args -> {
            carRepository.save(new Car("Ford", "Modeo", "Red", "Diesel", 2013));
            carRepository.save(new Car("Suzuki", "Van", "Black", "Pertamax", 2014));
			carRepository.save(new Car("Toyota","Mini Van","White","Pertamax",2015));
			carRepository.save(new Car("Toyota","Mini Van","Blue","Premium",2016));
			carRepository.save(new Car("Honda","Pick Up","Black","Pertamax",2018));
			carRepository.save(new Car("Honda","Hard Top","White","Premium",2019));
			carRepository.save(new Car("Toyota","Hard Top","Red","Diesel",2015));
			carRepository.save(new Car("Mitsubishi","Pick Up","Red","Diesel",2015));
			carRepository.save(new Car("Ford","Van","Blue","Diesel",2018));
        };
    }
}
