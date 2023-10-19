package com.oktay.RentACar.business.abstracts;

import com.oktay.RentACar.dtos.requests.CreateModelRequest;
import com.oktay.RentACar.dtos.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);

}
