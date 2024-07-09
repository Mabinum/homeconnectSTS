package com.example.demo.noticeComment.service;

import java.util.List;

import com.example.demo.board.entity.Notice;
import com.example.demo.member.entity.Member;
import com.example.demo.noticeComment.dto.NoticeCommentDTO;
import com.example.demo.noticeComment.entity.NoticeComment;

public interface NoticeCommentService {
	
	int register(NoticeCommentDTO dto);

	List<NoticeCommentDTO> getListByNoticeNo(int noticeNo);
	
	NoticeCommentDTO read(int no);

	void modify(NoticeCommentDTO dto);

	void remove(int no);

	default NoticeComment dtoToEntity(NoticeCommentDTO dto) {

		Member member = Member.builder().userId(dto.getWriter()).build(); //엔티티 생성

		Notice notice = Notice.builder().no(dto.getNoticeNo()).build();
		
		NoticeComment entity = NoticeComment.builder()
				.commentNo(dto.getCommentNo())
				.notice(notice)
				.content(dto.getContent())
				.writer(member)
				.build();
		
		return entity;
	}

	default NoticeCommentDTO entityToDto(NoticeComment entity) {

		NoticeCommentDTO dto = NoticeCommentDTO.builder()
				.commentNo(entity.getCommentNo())
				.noticeNo(entity.getNotice().getNo())
				.content(entity.getContent())
				.writer(entity.getWriter().getUserId())
				.regDate(entity.getRegDate()) 
				.modDate(entity.getModDate())
				.build();

		return dto;
	}
}
