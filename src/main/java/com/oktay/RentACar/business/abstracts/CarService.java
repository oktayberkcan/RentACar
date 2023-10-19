package com.oktay.RentACar.business.abstracts;

import com.oktay.RentACar.dtos.requests.CreateCarRequest;
import com.oktay.RentACar.dtos.requests.UpdateCarRequest;
import com.oktay.RentACar.dtos.responses.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    void add(CreateCarRequest createCarRequest);
    void update(UpdateCarRequest updateCarRequest);
}
