package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

//@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
		
	@Override
	public List<MemberDTO> getList() {
		
		List<Member> entityList = repository.findAll();		
		
		List<MemberDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());

		return dtoList;
	}
	
	@Override
	public boolean register(MemberDTO dto) {
		String id = dto.getUserId();
		MemberDTO getDto = read(id);
		if (getDto != null) {
			System.out.println("사용중인 아이디입니다.");
			return false;
		}
		Member entity = dtoToEntity(dto);
		
		// 패스워드 인코더로 패스워드 암호화하기
		String enPw = passwordEncoder.encode(entity.getPw());
		entity.setPw(enPw);


		repository.save(entity);
		return true;
	}

	@Override
	public MemberDTO read(String userId) {
		Optional<Member> result = repository.findByUserId(userId);
		if (result.isPresent()) {
			Member member = result.get();
			System.out.println("성공");
			return entityToDto(member);
		} else {
			return null;
		}
	}

	@Override
	public String idCheck(String userId) {
		Optional<Member> result = repository.findByUserId(userId);
		if (result.isPresent()) {
			System.out.println("아이디 중복");
			return "아이디가 중복되었습니다.";
		} else {
			return "사용가능한 아이디입니다.";
		}
	}
	
	@Override
	public MemberDTO nameModify(MemberDTO dto) {
		Optional<Member> result = repository.findByUserId(dto.getUserId());
		if (result.isPresent()) {
			Member member = result.get();
			member.setName(dto.getName());
			repository.save(member);
			
			return entityToDto(member);
		} else {
	        // Optional 값이 비어있는 경우에 대한 처리
	        throw new RuntimeException("Member not found with userId: " + dto.getUserId());
	    }
	}
//	@Override
//	public MemberDTO nameModify1(MemberDTO dto) {
//		Optional<Member> result = repository.findByUserId(dto.getUserId());
//		if (result.isPresent()) {
//			Member member = result.get();
//			member.setName(dto.getName());
//			repository.save(member);
//			
//			return entityToDto(member);
//		} else {
//			// Optional 값이 비어있는 경우에 대한 처리
//			throw new RuntimeException("Member not found with userId: " + dto.getUserId());
//		}
//	}
}
