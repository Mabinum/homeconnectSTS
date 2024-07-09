package com.example.demo.comment.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService service;

	//게시물별 댓글 목록 조회
	@ResponseBody
	@GetMapping("/list")
	public List<CommentDTO> list(@RequestParam(name = "boardNo") int boardNo) {
		List<CommentDTO> commentlist = service.getListByBoardNo(boardNo);

		return commentlist;
	}
	
	@ResponseBody
	@GetMapping("/notice/list")
	public List<CommentDTO> list2(@RequestParam(name = "noticeNo") int noticeNo) {
		List<CommentDTO> commentlist = service.getListByNoticeNo(noticeNo);

		return commentlist;
	}
		
	@ResponseBody
	@PostMapping("/register")
	public HashMap<String,Boolean> register(@RequestBody CommentDTO dto, Principal principal) { // 인증 객체
		HashMap<String,Boolean> map = new HashMap<>();
		String id = principal.getName(); // 인증객체에서 사용자 아이디 꺼내기
		dto.setWriter(id);		
		service.register(dto);
		map.put("success", true);
		return map;
	}
	
	@ResponseBody
	@PutMapping("/modify")
	public void modify(@RequestBody CommentDTO dto, Principal principal) {
		 service.modify(dto);
	}

	@ResponseBody
	@DeleteMapping("/remove")
	public HashMap<String,Boolean> remove(@RequestParam(name = "commentNo") int commentNo) {
		HashMap<String,Boolean> map = new HashMap<>();
		service.remove(commentNo);
		map.put("success", true);
		return map;
	}

}