package com.oktay.RentACar.webApi.controllers;

import com.oktay.RentACar.business.abstracts.CarService;
import com.oktay.RentACar.dtos.requests.CreateCarRequest;
import com.oktay.RentACar.dtos.requests.UpdateCarRequest;
import com.oktay.RentACar.dtos.responses.GetAllCarsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
    private CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()CreateCarRequest createCarRequest) {
        this.carService.add(createCarRequest);
    }
    @PutMapping()
    public void update(@RequestBody() UpdateCarRequest updateCarRequest) {
        this.carService.update(updateCarRequest);
    }

}
