package com.example.demo.board.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.dto.NoticeDTO;
import com.example.demo.board.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
    NoticeService service;

	@PostMapping("/register")
	public ResponseEntity<Integer> register(@RequestBody NoticeDTO dto, Principal principal) {
		
		String id = principal.getName();
		dto.setWriter(id);
		
		int no = service.register(dto);
		return new ResponseEntity<>(no, HttpStatus.OK); //200성공코드와 게시물목록을 반환한다
	}
	

	@GetMapping("/list")
	public ResponseEntity<List<NoticeDTO>> getList() {
		List<NoticeDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); //200성공코드와 게시물목록을 반환한다
	}

	@GetMapping("/read")
	public ResponseEntity<NoticeDTO> read(@RequestParam(name = "no") int no) {
		NoticeDTO dto = service.read(no);
		return new ResponseEntity<>(dto, HttpStatus.OK); //200성공코드와 게시물정보를 반환한다
	}

	
	@PutMapping("/modify")
	public ResponseEntity modify(@RequestBody NoticeDTO dto) {
		 service.modify(dto);
		 return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/remove")
	public ResponseEntity remove(@RequestParam(name = "no") int no) {
		service.remove(no);
		return new ResponseEntity(HttpStatus.OK); 
	}
}
