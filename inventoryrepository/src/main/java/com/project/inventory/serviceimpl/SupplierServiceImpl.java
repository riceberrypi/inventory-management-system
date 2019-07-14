package com.project.inventory.serviceimpl;

import com.project.inventory.dto.SupplierDto;
import com.project.inventory.entity.SupplierEntity;
import com.project.inventory.repository.SupplierRepository;
import com.project.inventory.service.SupplierService;
import com.project.inventory.utils.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public SupplierDto createUser(SupplierDto supplierDto) {
        SupplierEntity supplierEntity = modelMapper.map(supplierDto,SupplierEntity.class);
        supplierEntity.setSupplierId(idGenerator.generateId());

        if(supplierRepository.findBySupplierName(supplierDto.getSupplierName()) != null)
            throw new RuntimeException("Supplier name exists!");

        SupplierEntity storedSupplierDetails = supplierRepository.save(supplierEntity);

        SupplierDto returnSupplier = modelMapper.map(storedSupplierDetails,SupplierDto.class);

        return returnSupplier;
    }

    @Transactional
    @Override
    public SupplierDto updateUser(SupplierDto supplierDto) {
        SupplierEntity supplierEntity = supplierRepository.findBySupplierId(supplierDto.getSupplierId());
        SupplierDto returnValue;

        if(Objects.nonNull(supplierEntity)){
            supplierEntity.setSupplierName(supplierDto.getSupplierName());

            SupplierEntity storedSupplierDetails = supplierRepository.save(supplierEntity);

            returnValue = modelMapper.map(storedSupplierDetails,SupplierDto.class);
        }else{
            throw new RuntimeException("Record doesnt exists!");
        }

        return returnValue;
    }

    @Override
    public SupplierDto getSupplierBySupplierId(String id) {
        SupplierEntity supplierEntity = supplierRepository.findBySupplierId(id);
        SupplierDto supplierDto;
        if(Objects.nonNull(supplierEntity))
            supplierDto = modelMapper.map(supplierEntity,SupplierDto.class);
        else
            throw new RuntimeException("Supplier not found!");

        return supplierDto;
    }

    @Override
    public SupplierDto getSupplierBySupplierName(String name) {
        SupplierEntity supplierEntity = supplierRepository.findBySupplierName(name);
        SupplierDto supplierDto;

        if(Objects.nonNull(supplierEntity))
            supplierDto = modelMapper.map(supplierEntity,SupplierDto.class);
        else
            throw new RuntimeException("Supplier not found!");

        return supplierDto;
    }

    @Transactional
    @Override
    public void deleteSupplier(String id) {
        SupplierEntity supplierEntity = supplierRepository.findBySupplierId(id);
        if(Objects.nonNull(supplierEntity))
            supplierRepository.delete(supplierEntity);
        else
            throw new RuntimeException("User not found!");
    }
}
