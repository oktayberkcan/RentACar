package com.oktay.RentACar.dataAccess.abstracts;

import com.oktay.RentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepository  extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}
