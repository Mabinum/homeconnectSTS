package com.example.demo.fee.service;

import java.util.List;

import com.example.demo.fee.dto.FeeDTO;
import com.example.demo.fee.entity.FeeEntity;

public interface FeeService {
	
	String register(FeeDTO dto);
    List<FeeDTO> getList();
    FeeDTO read(String userId);
    void modify(FeeDTO dto);
    void remove(String userId);
    
    default FeeEntity dtoToEntity(FeeDTO dto) {
		FeeEntity entity = FeeEntity.builder()
				.userId(dto.getUserId())
				.month(dto.getMonth())
				.water(dto.getWater())
				.electric(dto.getElectric())
				.maintenance(dto.getMaintenance())
				.build();
		return entity;
	}

	default FeeDTO entityToDto(FeeEntity entity) {
		FeeDTO dto = FeeDTO.builder()
				.userId(entity.getUserId())
				.month(entity.getMonth())
				.water(entity.getWater())
				.electric(entity.getElectric())
				.maintenance(entity.getMaintenance())
				.build();
		return dto;
	}
    
}