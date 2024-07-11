package com.example.demo.member.controller;

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

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.NoticeService;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@RestController
@RequestMapping("/login")
public class MemberController {
	
	@Autowired
    MemberService service;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	NoticeService noticeService;

//	회원가입 정보 DB에 보내기
	@PostMapping("/signup")
	public ResponseEntity<Boolean> register(@RequestBody MemberDTO dto) {
		boolean result = service.register(dto);
		return new ResponseEntity<>(result, HttpStatus.CREATED); //201성공코드와 처리결과 반환
	}

	@GetMapping("/")
	public ResponseEntity<MemberDTO> read(@RequestParam(name = "userId") String userId, @RequestParam(name = "pw") String pw) {
		MemberDTO dto = service.read(userId);
		return new ResponseEntity<>(dto, HttpStatus.OK); //200성공코드와 회원목록 반환
	}
	
	@GetMapping("/idcheck")
	public ResponseEntity<String> CheckID(@RequestParam(name="userId") String userId) {
		String result = service.idCheck(userId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/nameModify")
	public ResponseEntity<MemberDTO> modify(@RequestBody MemberDTO dto) {
		 MemberDTO result = service.nameModify(dto);
		 return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PutMapping("/addressModify")
	public ResponseEntity<MemberDTO> modify2(@RequestBody MemberDTO dto) {
		MemberDTO result = service.addressModify(dto);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}

	@PutMapping("/pwModify")
	public ResponseEntity<MemberDTO> modify3(@RequestBody MemberDTO dto) {
		MemberDTO result = service.pwModify(dto);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@DeleteMapping("/remove")
	public ResponseEntity remove(@RequestParam(name = "userId") String userId) {
		boardService.userIdRemove(userId);
		noticeService.userIdRemove(userId);
		service.remove(userId);
		
		return new ResponseEntity(HttpStatus.OK);
	}
}
