package com.example.demo.noticeComment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.entity.Notice;
import com.example.demo.noticeComment.dto.NoticeCommentDTO;
import com.example.demo.noticeComment.entity.NoticeComment;
import com.example.demo.noticeComment.repository.NoticeCommentRepository;

@Service
public class NoticeCommentServiceImpl implements NoticeCommentService{
	
	@Autowired
	private NoticeCommentRepository repository;
	
	@Override
	public int register(NoticeCommentDTO dto) {
		NoticeComment entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getCommentNo();
	}

	@Override
	public List<NoticeCommentDTO> getListByNoticeNo(int noticeNo) {
		Notice notice = Notice.builder().no(noticeNo).build();  //엔티티 생성
		List<NoticeComment> entityList = repository.findByNotice(notice);
		List<NoticeCommentDTO> dtoList = new ArrayList<>();
		for (NoticeComment entity : entityList) {
			NoticeCommentDTO dto = entityToDto(entity);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public NoticeCommentDTO read(int no) {
		Optional<NoticeComment> result = repository.findById(no);
		if(result.isPresent()) {
			NoticeComment entity = result.get();
			return entityToDto(entity);
		}
		return null;
	}

	@Override
	public void modify(NoticeCommentDTO dto) {
		int commentNo = dto.getCommentNo();
		Optional<NoticeComment> result = repository.findById(commentNo);
		if(result.isPresent()) {
			NoticeComment entity = result.get();
			entity.setContent(dto.getContent());
			repository.save(entity);
		}
	}

	@Override
	public void remove(int no) {
		repository.deleteById(no);
	}	

}
