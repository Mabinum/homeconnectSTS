package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.NoticeDTO;
import com.example.demo.board.entity.Notice;
import com.example.demo.member.entity.Member;

public interface NoticeService {
	int register(NoticeDTO dto); //게시물 등록

	List<NoticeDTO> getList(); //게시물 목록 조회

	NoticeDTO read(int no); //게시물 상세 조회

	void modify(NoticeDTO dto); //게시물 수정

	void remove(int no); //게시물 삭제

	default Notice dtoToEntity(NoticeDTO dto) {
		Member member = Member.builder().userId(dto.getWriter()).build();
		
		Notice entity = Notice.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return entity;
	}

	default NoticeDTO entityToDto(Notice entity) {
		NoticeDTO dto = NoticeDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter().getUserId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		return dto;
	}
}
