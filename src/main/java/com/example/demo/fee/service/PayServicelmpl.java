//package com.example.demo.fee.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.fee.dto.PayDTO;
//import com.example.demo.fee.entity.PayEntity;
//import com.example.demo.fee.repository.PayRepository;
//
//@Service
//public class PayServicelmpl implements PayService {
//
//	@Autowired
//	PayRepository repository;
//
//	@Override
//	public String register(PayDTO dto) {
//		PayEntity entity = dtoToEntity(dto);
//		repository.save(entity);
//		
//		return entity.getMerchant_uid();
//	}
//
//	@Override
//	public List<PayDTO> getList() {
//		List<PayEntity> entityList = repository.findAll();
//		List<PayDTO> dtoList = entityList.stream()
//				.map(entity -> entityToDto(entity))
//				.collect(Collectors.toList());
//		
//		return dtoList;
//	}
//
//	@Override
//	public PayDTO read(String merchant_uid) {
//		Optional<PayEntity> result = repository.findById(merchant_uid);
//		if(result.isPresent()) {
//			PayEntity pay = result.get();
//			return entityToDto(pay);
//		} else {
//			return null;			
//		}
//	}
//	
//}
