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
    public String register(FeeDTO dto) {
        FeeEntity entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getUserId();
    }

    @Override
    public List<FeeDTO> getListByUserId(String userId) {
        List<FeeEntity> entityList = repository.findByUserId(userId);
        return entityList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeeDTO read(String userId) {
//    	Optional<FeeEntity> result = repository.findByUserId(userId);
//        return result.map(this::entityToDto).orElse(null);
    	Optional<FeeEntity> result = repository.findByUserId(userId).stream().findFirst(); // 단일 엔티티 반환하도록 수정
        return result.map(this::entityToDto).orElse(null);
    }

    @Override
    public void modify(FeeDTO dto) {
        Optional<FeeEntity> result = repository.findById(dto.getNo());
        if (result.isPresent()) {
            FeeEntity entity = result.get();
            entity.setMonth(dto.getMonth());
            entity.setElectric(dto.getElectric());
            entity.setWater(dto.getWater());
            entity.setMaintenance(dto.getMaintenance());
            repository.save(entity);
        }
    }

    @Override
    public void remove(String userId) {
        List<FeeEntity> entities = repository.findByUserId(userId);
        repository.deleteAll(entities);
    }

}