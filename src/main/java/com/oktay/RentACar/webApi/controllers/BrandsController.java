package com.oktay.RentACar.webApi.controllers;

import com.oktay.RentACar.business.abstracts.BrandService;
import com.oktay.RentACar.dtos.requests.CreateBrandRequest;
import com.oktay.RentACar.dtos.requests.UpdateBrandRequest;
import com.oktay.RentACar.dtos.responses.GetAllBrandsResponse;
import com.oktay.RentACar.dtos.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }


}
