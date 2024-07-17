package com.example.demo.member.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.repository.NoticeRepository;
import com.example.demo.comment.repository.CommentRepository;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.noticeComment.repository.NoticeCommentRepository;

//@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	NoticeCommentRepository noticeCommentRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<MemberDTO> getList() {

		List<Member> entityList = repository.findAll();

		List<MemberDTO> dtoList = entityList.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList());

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

	@Override
	public MemberDTO addressModify(MemberDTO dto) {
		Optional<Member> result = repository.findByUserId(dto.getUserId());
		if (result.isPresent()) {
			Member member = result.get();
			member.setAddress(dto.getAddress());
			repository.save(member);

			return entityToDto(member);
		} else {
			// Optional 값이 비어있는 경우에 대한 처리
			throw new RuntimeException("Member not found with userId: " + dto.getUserId());
		}
	}

	@Override
	public MemberDTO pwModify(MemberDTO dto) {
		Optional<Member> result = repository.findByUserId(dto.getUserId());
		if (result.isPresent()) {
			Member member = result.get();
			String enPw = passwordEncoder.encode(dto.getPw());
			member.setPw(enPw);
			repository.save(member);

			return entityToDto(member);
		} else {
			// Optional 값이 비어있는 경우에 대한 처리
			throw new RuntimeException("Member not found with userId: " + dto.getUserId());
		}
	}

	@Override
	public void remove(String userId) {
		noticeCommentRepository.deleteByWriterUserId(userId);
		commentRepository.deleteByWriterUserId(userId);
		repository.deleteByUserId(userId);
	}

	@Override
	public void communityJoin(MemberDTO dto) {
		Optional<Member> result = repository.findByUserId(dto.getUserId());
		if (result.isPresent()) {
			Member member = result.get();
//			member.setCommunityNo(dto.getCommunityNo());
			repository.save(member);
		} else {
			throw new RuntimeException("회원 정보를 찾을 수 없습니다.");
		}

	}

//	@Override
//	public List<MemberDTO> getCommunityNo(String communityNo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 @Override
	    public void updateCommunityNoByUserId(MemberDTO dto) {
		 	Optional<Member> result = repository.findByCommunityNo(dto.getCommunityNo());
		 	Member member = result.get();
//		 	member.setCommunityNo(dto.getCommunityNo());
	        repository.save(member);
	}

	
//	@Override
//	public List<MemberDTO> getCommunityNo(Integer communityNo) {
//	    List<Member> members = repository.findByCommunityNo(communityNo);
//	    return members.stream()
//	                  .map(this::entityToDto)
//	                  .collect(Collectors.toList());
//	}
}
