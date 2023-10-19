package com.oktay.RentACar.business.concretes;

import com.oktay.RentACar.business.abstracts.CarService;
import com.oktay.RentACar.core.utilities.mappers.ModelMapperService;
import com.oktay.RentACar.dataAccess.abstracts.CarRepository;
import com.oktay.RentACar.dtos.requests.CreateCarRequest;
import com.oktay.RentACar.dtos.requests.UpdateCarRequest;
import com.oktay.RentACar.dtos.responses.GetAllCarsResponse;
import com.oktay.RentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = carRepository.findAll();


        List<GetAllCarsResponse> carsResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class)).collect(Collectors.toList());

        return carsResponses;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {

        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);

        this.carRepository.save(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

        this.carRepository.save(car);
    }


}
