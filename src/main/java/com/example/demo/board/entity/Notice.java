package com.example.demo.board.entity;

import com.example.demo.member.entity.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; // 글번호

	@Column(length = 100, nullable = false)
	String title; // 제목

	@Column(length = 1500, nullable = false)
	String content; // 내용

	@ManyToOne
	Member writer; // 작성자

}
