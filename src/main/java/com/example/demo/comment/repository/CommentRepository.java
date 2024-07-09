package com.example.demo.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.board.entity.Board;
import com.example.demo.board.entity.Notice;
import com.example.demo.comment.entity.Comment;

import jakarta.transaction.Transactional;

@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByBoard(Board board);
	List<Comment> findByNotice(Notice notice);
	
	void deleteByBoard(Board board);
	void deleteByNotice(Notice notice);

}

