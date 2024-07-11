package com.example.demo.board.service;

import java.util.List;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.entity.Board;
import com.example.demo.member.entity.Member;


public interface BoardService {

	int register(BoardDTO dto); //게시물 등록

	List<BoardDTO> getList(); //게시물 목록 조회

	BoardDTO read(int no); //게시물 상세 조회

	void modify(BoardDTO dto); //게시물 수정

	void remove(int no); //게시물 삭제
	
	void userIdRemove(String userId);
	
	default Board dtoToEntity(BoardDTO dto) {
		Member member = Member.builder().userId(dto.getWriter()).build();
		
		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member)
				.build();
		return entity;
	}

	default BoardDTO entityToDto(Board entity) {
		BoardDTO dto = BoardDTO.builder()
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
