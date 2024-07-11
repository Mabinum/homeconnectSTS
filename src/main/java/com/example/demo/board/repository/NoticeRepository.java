package com.example.demo.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Notice;

import jakarta.transaction.Transactional;

@Transactional
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	void deleteByWriterUserId(String writerUserId);
	
	List<Notice> findByWriterUserId(String userId);
}
