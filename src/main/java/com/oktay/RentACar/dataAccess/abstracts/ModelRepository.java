package com.oktay.RentACar.dataAccess.abstracts;


import com.oktay.RentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
