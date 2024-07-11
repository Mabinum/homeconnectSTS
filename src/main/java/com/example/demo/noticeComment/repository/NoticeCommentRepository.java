package com.example.demo.noticeComment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Notice;
import com.example.demo.noticeComment.entity.NoticeComment;

import jakarta.transaction.Transactional;

@Transactional
public interface NoticeCommentRepository extends JpaRepository<NoticeComment, Integer>{
	List<NoticeComment> findByNotice(Notice notice);
	
	void deleteByNotice(Notice notice);
	
	void deleteByNoticeNo(int noticeNo);
	
	void deleteByUserId(String userId);
}
