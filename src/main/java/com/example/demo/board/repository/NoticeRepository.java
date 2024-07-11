package com.example.demo.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	void deleteByUserId(String userId);
}
