package com.example.demo.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.comment.repository.CommentRepository;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repository;

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}

	@Override
	public Page<BoardDTO> getList(int page) {
//		Page<Board> entityList = repository.findAll();		
//		Page<BoardDTO> dtoList = entityList.stream()
//				.map(entity -> entityToDto(entity))
//				.collect(Collectors.toList());
//		
		// 페이지 번호를 인덱스로 변경. 페이지 인덱스는 0부터 시작됨
		int pageNum = (page == 0) ? 0 : page - 1;
		//페이지번호, 개수, 정렬방식을 입력하여 페이지 정보 생성
		Pageable pageable = PageRequest.of(pageNum, 5, Sort.by("no").descending());
		//게시물 목록 조회
		Page<Board> entityPage = repository.findAll(pageable);
		//스트림을 사용하여 엔티티 리스트를 DTO 리스트로 변환
		Page<BoardDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );

				
		return dtoPage;
	}

	@Override
	public BoardDTO read(int no) {
        Optional<Board> result = repository.findById(no);
        if(result.isPresent()) {
        	Board board =  result.get();
        	return entityToDto(board);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(BoardDTO dto) {
        Optional<Board> result = repository.findById(dto.getNo());
        if(result.isPresent()){
            Board entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            repository.save(entity);
        }
	}

	@Override
	public void remove(int no) {
		commentRepository.deleteByBoardNo(no);
		repository.deleteById(no);
	}
	
	@Override
	public void userIdRemove(String userId) {
		List<Board> result = repository.findByWriterUserId(userId);
		for(Board board : result) {
			commentRepository.deleteByBoardNo(board.getNo());
			repository.deleteById(board.getNo());			
		}
	}
	
	@Override
	public List<BoardDTO> searchtitle(String title) {
		List<Board> entityList = repository.findByTitleContaining(title);		
		List<BoardDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());

		return dtoList;
	}
	

}
