package com.example.demo.fee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.fee.dto.FeeDTO;
import com.example.demo.fee.entity.FeeEntity;
import com.example.demo.fee.repository.FeeRepository;

@Service
public class FeeServicelmpl implements FeeService {
	
	@Autowired
	FeeRepository repository;
	
	 @Override
	    public String register(FeeDTO dto) {
	        FeeEntity entity = dtoToEntity(dto);
	        repository.save(entity);
	        return entity.getUserId();
	    }

	    @Override
	    public List<FeeDTO> getListByUserId(String userId) {
	        List<FeeEntity> entityList = repository.findByUserId(userId);
	        List<FeeDTO> dtoList = entityList.stream()
	                .map(this::entityToDto)
	                .collect(Collectors.toList());
	        return dtoList;
	    }

//	    @Override
//	    public FeeDTO read(String userId) {
//	        Optional<FeeEntity> result = repository.findByUserId(userId);
//	        return result.map(this::entityToDto).orElse(null);
//	    }
//
//	    @Override
//	    public void modify(FeeDTO dto) {
//	        Optional<FeeEntity> result = repository.findById(dto.getUserId());
//	        if(result.isPresent()){
//	            FeeEntity entity = result.get();
//	            entity.setMonth(dto.getMonth());
//	            entity.setElectric(dto.getElectric());
//	            entity.setWater(dto.getWater());
//	            entity.setMaintenance(dto.getMaintenance());
//	            repository.save(entity);
//	        }
//	    }
//
//	    @Override
//	    public void remove(String userId) {
//	        repository.deleteById(userId);
//	    }

	    public FeeEntity dtoToEntity(FeeDTO dto) {
	        return new FeeEntity(0, dto.getUserId(), dto.getMonth(), dto.getWater(), dto.getElectric(), dto.getMaintenance());
	    }

	    public FeeDTO entityToDto(FeeEntity entity) {
	        return new FeeDTO(entity.getUserId(), entity.getMonth(), entity.getWater(), entity.getElectric(), entity.getMaintenance());
	    }
	}
