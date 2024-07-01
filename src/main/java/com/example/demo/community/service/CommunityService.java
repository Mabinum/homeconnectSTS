package com.example.demo.community.service;

import java.util.List;

import com.example.demo.community.dto.CommunityDTO;
import com.example.demo.community.entity.Community;

public interface CommunityService {

	// 게시물 등록
		int register(CommunityDTO dto);

		// 게시물 목록조회
		List<CommunityDTO> getList();

		// 게시물 상세조회
		CommunityDTO read(int no);

		// 게시물 수정
		void modify(CommunityDTO dto);

		// 게시물 삭제
		int remove(int no);

		// dto를 엔티티로 변환하는 메소드
		default Community dtoToEntity(CommunityDTO dto) { // default키워드를 사용하여 일반메소드 추가
			Community entity = Community.builder() // builder를 사용하면 필요한 값만 넣어서 인스턴스를 생성할수 있음
					.no(dto.getNo())
					.title(dto.getTitle())
					.content(dto.getContent())
					.writer(dto.getWriter()) //날짜 생략
					.build();
			return entity;
		}

		// 엔티티를 dto로 변환하는 메소드
		default CommunityDTO entityToDto(Community entity) {

			CommunityDTO dto = CommunityDTO.builder()
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
