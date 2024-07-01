package com.example.demo.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
    MemberService service;

//	회원가입 정보 DB에 보내기
	@PostMapping("/login/signup4")
	public ResponseEntity<Boolean> register(@RequestBody MemberDTO dto) {
		boolean result = service.register(dto);
		return new ResponseEntity<>(result, HttpStatus.CREATED); //201성공코드와 처리결과 반환
	}

//	로그인할때 DB에 데이터가 있는지, 있으면 일치하는지 확인하고 보내기
	@GetMapping("/login")
	public ResponseEntity<MemberDTO> read(@RequestParam(name = "userId") String userId, @RequestParam(name = "pw") String pw) {
		MemberDTO dto = service.read(userId);
		return new ResponseEntity<>(dto, HttpStatus.OK); //200성공코드와 회원목록 반환
	}
//	@GetMapping("/login")
//	public ResponseEntity<List<MemberDTO>> getList() {
//		List<MemberDTO> list = service.getList();
//		return new ResponseEntity<>(list, HttpStatus.OK); //200성공코드와 회원목록 반환
//	}
	
}
