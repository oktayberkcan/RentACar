package com.oktay.RentACar.business.concretes;

import com.oktay.RentACar.business.abstracts.ModelService;
import com.oktay.RentACar.core.utilities.mappers.ModelMapperService;
import com.oktay.RentACar.dataAccess.abstracts.ModelRepository;
import com.oktay.RentACar.dtos.requests.CreateModelRequest;
import com.oktay.RentACar.dtos.responses.GetAllModelsResponse;
import com.oktay.RentACar.entities.concretes.Brand;
import com.oktay.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();


        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);

        this.modelRepository.save(model);
    }
}
