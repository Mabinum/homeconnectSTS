package com.example.demo.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.NoticeDTO;
import com.example.demo.board.entity.Notice;
import com.example.demo.board.repository.NoticeRepository;
import com.example.demo.noticeComment.repository.NoticeCommentRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeRepository repository;

	@Autowired
	NoticeCommentRepository noticeCommentRepository;
	
	@Override
	public int register(NoticeDTO dto) {
		Notice entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}
	
	@Override
	public List<NoticeDTO> getList() {
		List<Notice> entityList = repository.findAll();		
		List<NoticeDTO> dtoList = entityList.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());

		return dtoList;
	}

	@Override
	public NoticeDTO read(int no) {
        Optional<Notice> result = repository.findById(no);
        if(result.isPresent()) {
        	Notice notice =  result.get();
        	return entityToDto(notice);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(NoticeDTO dto) {
        Optional<Notice> result = repository.findById(dto.getNo());
        if(result.isPresent()){
        	Notice entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            repository.save(entity);
        }
	}

	@Override
	public void remove(int no) {
		noticeCommentRepository.deleteByNoticeNo(no);
		repository.deleteById(no);
	}
	
	@Override
	public void userIdRemove(String userId) {
		List<Notice> result = repository.findByWriterUserId(userId);
		for(Notice notice : result) {
			noticeCommentRepository.deleteByNoticeNo(notice.getNo());
			repository.deleteById(notice.getNo());			
		}
	}

}