package com.example.demo.board.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.dto.NoticeDTO;
import com.example.demo.board.entity.Notice;
import com.example.demo.board.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeRepository repository;

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
		repository.deleteById(no);
	}
}
