package com.example.demo.community2.service;

import java.util.List;

import com.example.demo.community2.dto.Community2DTO;
import com.example.demo.community2.entity.Community2;

public interface Community2Service {

	// 게시물 등록
		int register(Community2DTO dto);

		// 게시물 목록조회
		List<Community2DTO> getList();

		// 게시물 상세조회
		Community2DTO read(int no);

		// 게시물 수정
		void modify(Community2DTO dto);

		// 게시물 삭제
		int remove(int no);

		// dto를 엔티티로 변환하는 메소드
		default Community2 dtoToEntity(Community2DTO dto) { // default키워드를 사용하여 일반메소드 추가
			Community2 entity = Community2.builder() // builder를 사용하면 필요한 값만 넣어서 인스턴스를 생성할수 있음
					.no(dto.getNo())
					.title(dto.getTitle())
					.content(dto.getContent())
					.writer(dto.getWriter()) //날짜 생략
					.build();
			return entity;
		}

		// 엔티티를 dto로 변환하는 메소드
		default Community2DTO entityToDto(Community2 entity) {

			Community2DTO dto = Community2DTO.builder()
					.no(entity.getNo())
					.title(entity.getTitle())
					.content(entity.getContent())
					.writer(entity.getWriter())
					.regDate(entity.getRegDate())
					.modDate(entity.getModDate())
					.imgPath(entity.getImgPath()) //이미지경로 추가
					.build();

			return dto;
		}
	
}
