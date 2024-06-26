package com.example.demo.member.service;

import java.util.List;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;

public interface MemberService {

	List<MemberDTO> getList(); //회원 목록조회
	
	boolean register(MemberDTO dto); //회원 등록

	MemberDTO read(String id); //회원 단건 조회
	
	//엔티티를 DTO로 변환하는 메소드
	default MemberDTO entityToDto(Member entity) {
		MemberDTO dto = MemberDTO.builder()
				.userId(entity.getUserId())
				.pw(entity.getPw())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
	
	//DTO를 엔티티로 변환하는 메소드
	default Member dtoToEntity(MemberDTO dto) {
		Member entity = Member.builder()
				.userId(dto.getUserId())
				.pw(dto.getPw())
				.name(dto.getName())
				.build();
		return entity;
	}
}
