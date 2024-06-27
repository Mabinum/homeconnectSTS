package com.example.demo.fee.service;

import java.util.List;
import java.util.Optional;
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
	public int register(FeeDTO dto) {
		FeeEntity entity = dtoToEntity(dto);
		repository.save(entity);
		
		return entity.getNo();
	}

	@Override
	public List<FeeDTO> getList() {
		List<FeeEntity> entityList = repository.findAll();
		List<FeeDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public FeeDTO read(int no) {
		Optional<FeeEntity> result = repository.findById(no);
        if(result.isPresent()) {
        	FeeEntity fee = result.get();
        	return entityToDto(fee);
        } else {
		return null;
        }
	}

	@Override
	public void modify(FeeDTO dto) {
		Optional<FeeEntity> result = repository.findById(dto.getNo());
        if(result.isPresent()){
            FeeEntity entity = result.get();
            entity.setMonth(dto.getMonth());
            entity.setElectric(dto.getElectric());
            entity.setWater(dto.getWater());
            entity.setMaintenance(dto.getMaintenance());
            repository.save(entity);
        }
	}

	@Override
	public void remove(int no) {
		repository.deleteById(no);
		
	}
}
