package com.jvmindonesia.restapi.repository;

import com.jvmindonesia.restapi.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    //class yang bertugas koneksi ke DB

//    List<Car> findByBrand(@Param("brand") String brand);
}
