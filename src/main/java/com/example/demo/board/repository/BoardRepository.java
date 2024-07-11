package com.example.demo.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer>{
	void deleteByWriterUserId(String writerUserId);
	
	List<Board> findByWriterUserId(String userId);
}
