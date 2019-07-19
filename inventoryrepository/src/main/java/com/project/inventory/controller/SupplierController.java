package com.project.inventory.controller;

import com.project.inventory.dto.SupplierDto;
import com.project.inventory.model.response.SupplierResponse;
import com.project.inventory.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path="/{id}")
    public ResponseEntity<SupplierResponse> getSupplierById(@PathVariable String id){
        SupplierDto supplierDto = supplierService.getSupplierBySupplierId(id);

        SupplierResponse supplierResponse = modelMapper.map(supplierDto,SupplierResponse.class);

        return ResponseEntity.ok(supplierResponse);
    }

    @GetMapping(path="/name/{name}")
    public ResponseEntity<SupplierResponse> getSupplierByName(@PathVariable String name){
        SupplierDto supplierDto = supplierService.getSupplierBySupplierName(name);

        SupplierResponse supplierResponse = modelMapper.map(supplierDto,SupplierResponse.class);

        return ResponseEntity.ok(supplierResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<SupplierResponse> createSupplier(@RequestBody SupplierDto supplierRequestModel){
       // ModelMapper modelMapper = new ModelMapper();

        SupplierDto supplierDto = modelMapper.map(supplierRequestModel,SupplierDto.class);

        SupplierDto createdUser = supplierService.createUser(supplierDto);

        SupplierResponse supplierResponse = modelMapper.map(createdUser,SupplierResponse.class);

        return ResponseEntity.ok(supplierResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<SupplierResponse> updateSupplier(@RequestBody SupplierDto supplierRequestModel){
        SupplierDto supplierDto = modelMapper.map(supplierRequestModel,SupplierDto.class);

        SupplierDto updateUser = supplierService.updateUser(supplierDto);

        SupplierResponse supplierResponse = modelMapper.map(updateUser,SupplierResponse.class);

        return ResponseEntity.ok(supplierResponse);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteSupplier(@PathVariable String id){
        supplierService.deleteSupplier(id);

        return id;
    }
}
