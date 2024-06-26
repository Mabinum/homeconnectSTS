package com.example.demo.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@RestController
@RequestMapping("/login")
public class MemberController {
	
	@Autowired
    MemberService service;

	@PostMapping("/signup")
	public ResponseEntity<Boolean> register(@RequestBody MemberDTO dto) {
		boolean result = service.register(dto);
		return new ResponseEntity<>(result, HttpStatus.CREATED); //201성공코드와 처리결과 반환
	}

	@GetMapping("/member/list")
	public ResponseEntity<List<MemberDTO>> getList() {
		List<MemberDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); //200성공코드와 회원목록 반환
	}
	
}
