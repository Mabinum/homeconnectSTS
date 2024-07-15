package com.example.demo.fee.service;

import java.util.List;

import com.example.demo.fee.dto.PayDTO;
import com.example.demo.fee.entity.PayEntity;

public interface PayService {

	String register(PayDTO dto);
	List<PayDTO> getList();
	PayDTO read(String merchant_uid);
	
	default PayEntity dtoToEntity(PayDTO dto) {
		PayEntity entity = PayEntity.builder()
				.imp_uid(dto.getImp_uid())
				.merchant_uid(dto.getMerchant_uid())
				.amount(dto.getAmount())
				.month(dto.getMonth())
				.buyer_name(dto.getBuyer_name())
				.card_name(dto.getCard_name())
				.email(dto.getEmail())
				.time(dto.getTime())
				.build();
		return entity;
	}
	
	default PayDTO entityToDto(PayEntity entity) {
		PayDTO dto = PayDTO.builder()
				.imp_uid(entity.getImp_uid())
				.merchant_uid(entity.getMerchant_uid())
				.amount(entity.getAmount())
				.month(entity.getMonth())
				.buyer_name(entity.getBuyer_name())
				.card_name(entity.getCard_name())
				.email(entity.getEmail())
				.time(entity.getTime())
				.build();
		return dto;
	}
}
