package com.example.demo.community2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.community.util.FileUtil;
import com.example.demo.community2.dto.Community2DTO;
import com.example.demo.community2.entity.Community2;
import com.example.demo.community2.repository.Community2Repository;

@Service
public class Community2ServiceImpl implements Community2Service{

	@Autowired
	Community2Repository repository;
	
	@Autowired
	private FileUtil fileUtil;
	
	// 상속받은 메소드 구현하기
		@Override
		public int register(Community2DTO dto) {

			Community2 entity = dtoToEntity(dto); // 파라미터로 전달받은 dto를 엔티티로 변환

			// 유틸클래스를 이용해서 파일을 폴더에 저장하고 파일이름을 반환받는다
			String imgPath = fileUtil.fileUpload(dto.getUploadFile());
			// 그리고 엔티티에 파일이름을 저장한다
			entity.setImgPath(imgPath);

			repository.save(entity); // 리파지토리로 게시물 등록
			int newNo = entity.getNo();

			return newNo; // 새로운 게시물의 번호 반환
		}

		@Override
		public List<Community2DTO> getList() {
			List<Community2> result = repository.findAll(); // 데이터베이스에서 게시물 목록을 가져온다
			List<Community2DTO> list = new ArrayList<>();
			list = result.stream() // 리스트에서 스트림 생성
					.map(entity -> entityToDto(entity)) // 중간연산으로 엔티티를 dto로 변환
					.collect(Collectors.toList()); // 최종연산으로 결과를 리스트로 변환

			return list; // 화면에 필요한 dto 리스트 반환
		}

		@Override
		public Community2DTO read(int no) { // 인자로 게시물 번호 받기

			Optional<Community2> result = repository.findById(no); // 특정 게시물 정보 가져오기

			if (result.isPresent()) {
				Community2 board = result.get();
				Community2DTO boardDTO = entityToDto(board); // 엔티티를 DTO로 변환
				return boardDTO; // DTO 반환
			} else {
				return null;
			}

		}

		@Override
		public void modify(Community2DTO dto) {
			// 업데이트 하는 항목은 '제목', '내용'

			// 전달받은 DTO에서 게시물 번호 꺼내고, 해당 게시물 조회
			Optional<Community2> result = repository.findById(dto.getNo());
			if (result.isPresent()) { // 해당 게시물이 존재하는지 확인
				Community2 entity = result.get();

				// 기존 엔티티에서 제목과 내용만 변경
				entity.setTitle(dto.getTitle());
				entity.setContent(dto.getContent());

				// 다시 저장
				repository.save(entity);
			}

		}

		@Override
		public int remove(int no) {

			Optional<Community2> result = repository.findById(no);

			if (result.isPresent()) {
				repository.deleteById(no);
				return 1; // 성공
			} else {
				return 0; // 실패
			}

		}
}
