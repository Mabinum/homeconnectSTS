package com.example.demo.community.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityDTO {

	int no;
	String title;
	String content;
	String writer;
	LocalDateTime regDate;
	LocalDateTime modDate;
	MultipartFile uploadFile; // 파일 스트림 저장
	String imgPath; // 파일 이름 꺼내올때
}
