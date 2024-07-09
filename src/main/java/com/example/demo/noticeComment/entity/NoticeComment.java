package com.example.demo.noticeComment.entity;

import com.example.demo.board.entity.Notice;
import com.example.demo.comment.entity.BaseEntity;
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
public class NoticeComment extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commentNo;

	@ManyToOne
	Notice notice; //외래키

    @Column(length = 1500)
    String content;	

    @ManyToOne
    Member writer; //외래키
    
}
