package com.example.demo.comment.service;

import java.util.List;

import com.example.demo.board.entity.Board;
import com.example.demo.board.entity.Notice;
import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.entity.Comment;
import com.example.demo.member.entity.Member;

public interface CommentService {

	int register(CommentDTO dto);

	List<CommentDTO> getListByBoardNo(int boardNo);
	List<CommentDTO> getListByNoticeNo(int noticeNo);
	
	CommentDTO read(int no);

	void modify(CommentDTO dto);

	void remove(int no);

	default Comment dtoToEntity(CommentDTO dto) {

		Member member = Member.builder().userId(dto.getWriter()).build(); //엔티티 생성

		Board board = Board.builder().no(dto.getBoardNo()).build();  //엔티티 생성

		Notice notice = Notice.builder().no(dto.getNoticeNo()).build();
		
		Comment entity = Comment.builder()
				.commentNo(dto.getCommentNo())
				.board(board)
				.notice(notice)
				.content(dto.getContent())
				.writer(member)
				.build();
		
		return entity;
	}

	default CommentDTO entityToDto(Comment entity) {

		CommentDTO dto = CommentDTO.builder()
				.commentNo(entity.getCommentNo())
				.boardNo(entity.getBoard().getNo())
				.noticeNo(entity.getNotice().getNo())
				.content(entity.getContent())
				.writer(entity.getWriter().getUserId())
				.regDate(entity.getRegDate()) 
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
