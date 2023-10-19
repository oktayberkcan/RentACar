package com.oktay.RentACar.business.concretes;

import  com.oktay.RentACar.business.abstracts.BrandService;
import com.oktay.RentACar.business.rules.BrandBusinessRules;
import com.oktay.RentACar.core.utilities.mappers.ModelMapperService;
import com.oktay.RentACar.dtos.requests.CreateBrandRequest;
import com.oktay.RentACar.dtos.requests.UpdateBrandRequest;
import com.oktay.RentACar.dtos.responses.GetAllBrandsResponse;
import com.oktay.RentACar.dataAccess.abstracts.BrandRepository;
import com.oktay.RentACar.dtos.responses.GetByIdBrandResponse;
import com.oktay.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {

     List<Brand> brands = brandRepository.findAll();
     List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();

     for (Brand brand : brands) {
         GetAllBrandsResponse getAllBrandsResponse = new GetAllBrandsResponse();
         getAllBrandsResponse.setId(brand.getId());
         getAllBrandsResponse.setName(brand.getName());

         brandsResponses.add(getAllBrandsResponse);
     }
     return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response =
                this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
            Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

            this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }


}
