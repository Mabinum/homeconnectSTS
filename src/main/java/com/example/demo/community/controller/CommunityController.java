package com.example.demo.community.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

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

import com.example.demo.community.dto.CommunityDTO;
import com.example.demo.community.repository.CommunityRepository;
import com.example.demo.community.service.CommunityService;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;

@RestController
@RequestMapping("/community")
public class CommunityController {

	@Autowired
	CommunityService service;
	
	@Autowired
	CommunityRepository repository;
	
	@Autowired
	MemberService memberService;
	

	// 목록불러오기
	@GetMapping("/list")
	public ResponseEntity<List<CommunityDTO>> getList() {
		List<CommunityDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); // 200성공코드와 게시물목록을 반환한다
	}

	// 등록처리

	@PostMapping("/register")
	// RedirectAttributes은 모델처럼 화면에 데이터를 전달하는 객체
	// 화면에서 전달한 데이터를 파라미터로 수집
	public ResponseEntity<Integer> registerPost(CommunityDTO dto, Principal principal) {

		String id = principal.getName();
		dto.setWriter(id);

		// 게시물 등록하고 새로운 게시물 번호 반환
		int no = service.register(dto);
		return new ResponseEntity<>(no, HttpStatus.OK);
	}

	// 상세화면
	@GetMapping("/read")
	public ResponseEntity<CommunityDTO> read(@RequestParam(name = "no") int no) {
		CommunityDTO dto = service.read(no);
		return new ResponseEntity<>(dto, HttpStatus.OK); // 200성공코드와 게시물정보를 반환한다
	}

	// 수정화면
	@PutMapping("/modify")
	public ResponseEntity modify(@RequestBody CommunityDTO dto, Principal principal) {
		service.modify(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/pluscommunityno")
	public ResponseEntity pluscommunityno(@RequestParam(name = "no") int no, Principal principal) {
		String id = principal.getName();
		service.plusCommunityNo(id,no);
		return new ResponseEntity(HttpStatus.OK);
	}

	// 삭제처리
	@DeleteMapping("/remove")
	public ResponseEntity remove(@RequestParam(name = "no") int no) {
		service.remove(no);
		return new ResponseEntity(HttpStatus.OK);
	}

	// localhost:8080/menu4/category?category=카테고리명
	// 카테고리 별 목록 불러오기 푸시 여부 확인 다시 확인
	@GetMapping("/category")
	public ResponseEntity<List<CommunityDTO>> getByCategory(@RequestParam(name = "category") String category) {
		List<CommunityDTO> list = service.getCategory(category);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/join")
	public ResponseEntity<MemberDTO> join(@RequestBody Map<String, Object> requestBody, Principal principal) {
	    String communityNo = (String) requestBody.get("communityNo");
	    String userId = principal.getName();

	    MemberDTO memberDTO = MemberDTO.builder().userId(userId).communityNo(communityNo).build();

	    memberService.communityJoin(memberDTO);

	    return new ResponseEntity<>(memberDTO, HttpStatus.OK);
	}
//	 @GetMapping("/communitymember")
//	    public ResponseEntity<List<Member>> getMembersByCommunityNo(@RequestParam Integer communityNo) {
//	        List<Member> members = memberService.getCommunityNo(communityNo);
//	        return new ResponseEntity<>(members, HttpStatus.OK);
//	    }
}