package com.example.demo.fee.service;

import java.util.List;

import com.example.demo.fee.dto.FeeDTO;
import com.example.demo.fee.entity.FeeEntity;

public interface FeeService {
	
	int register(FeeDTO dto);
    List<FeeDTO> getList();
    FeeDTO read(int id);
    void modify(FeeDTO dto);
    void remove(int id);
    
    default FeeEntity dtoToEntity(FeeDTO dto) {
		FeeEntity entity = FeeEntity.builder()
				.no(dto.getNo())
				.month(dto.getMonth())
				.water(dto.getWater())
				.electric(dto.getElectric())
				.maintenance(dto.getMaintenance())
				.build();
		return entity;
	}

	default FeeDTO entityToDto(FeeEntity entity) {
		FeeDTO dto = FeeDTO.builder()
				.no(entity.getNo())
				.month(entity.getMonth())
				.water(entity.getWater())
				.electric(entity.getElectric())
				.maintenance(entity.getMaintenance())
				.build();
		return dto;
	}
    
}
