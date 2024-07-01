package com.example.demo.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.community.dto.CommunityDTO;
import com.example.demo.community.service.CommunityService;

@RestController
@RequestMapping("/menu4")
public class CommunityController {
	
	@Autowired
	CommunityService service;
	
//	 // 메인화면
//    @GetMapping("/main")
//    public void main() {
//    }

    // 목록화면
//    @GetMapping("/community")
//    public void list(Model model) {
//        List<CommunityDTO> list = service.getList(); // 서비스로 게시물 목록 가져오기
//        model.addAttribute("list", list); // 화면에 게시물 리스트 전달
//    }
	
	// 목록불러오기
    @GetMapping("/community")
	public ResponseEntity<List<CommunityDTO>> getList() {
		List<CommunityDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); //200성공코드와 게시물목록을 반환한다
	}

//    // 등록화면
//    @GetMapping("/community")
//    public void register() {
//    }

    // 등록처리
    @PostMapping("/communityregister")
    // RedirectAttributes은 모델처럼 화면에 데이터를 전달하는 객체
    // 화면에서 전달한 데이터를 파라미터로 수집
    public void registerPost(CommunityDTO dto, RedirectAttributes redirectAttributes) {

        // 게시물 등록하고 새로운 게시물 번호 반환
        int no = service.register(dto);
        
        // 목록화면에 새로운 게시물 번호 전달
        redirectAttributes.addFlashAttribute("msg", no);
        
        // 목록화면으로 이동. HTML경로아님. url주소를 작성할것
//        return "redirect:/menu4/community";
    }

    // 상세화면
    @GetMapping("/communitysignup")
    public void read(@RequestParam(name = "no") int no, Model model) {
    	CommunityDTO dto = service.read(no);
        model.addAttribute("dto", dto);
    }

    // 수정화면
    @GetMapping("/modify")
    public void modify(@RequestParam(name = "no") int no, Model model) {
    	CommunityDTO dto = service.read(no); // 게시물 번호로 조회
        model.addAttribute("dto", dto); // 화면에 게시물 정보 전달
    }

    // 수정처리
    @PostMapping("/modify")
    public String modifyPost(CommunityDTO dto, RedirectAttributes redirectAttributes) {
        // 게시물 수정
        service.modify(dto);
        // 리다이렉트 주소에 파라미터 추가 (?no=1)
        redirectAttributes.addAttribute("no", dto.getNo());
        // 상세화면으로 이동
        return "redirect:/board/read";
    }

    // 삭제처리
    @PostMapping("/remove")
    public String removePost(int no) {
        service.remove(no);
        return "redirect:/board/list";
    }


}
