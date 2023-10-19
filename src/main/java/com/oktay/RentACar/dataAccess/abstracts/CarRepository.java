package com.oktay.RentACar.dataAccess.abstracts;

import com.oktay.RentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
