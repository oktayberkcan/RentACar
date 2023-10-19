package com.oktay.RentACar.business.abstracts;

import com.oktay.RentACar.dtos.requests.CreateBrandRequest;
import com.oktay.RentACar.dtos.requests.UpdateBrandRequest;
import com.oktay.RentACar.dtos.responses.GetAllBrandsResponse;
import com.oktay.RentACar.dtos.responses.GetByIdBrandResponse;


import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);



}
