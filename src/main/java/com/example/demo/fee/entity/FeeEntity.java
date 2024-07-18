package com.example.demo.fee.entity;

import com.example.demo.comment.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fees")
//@IdClass(FeeId.class) // 수정
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; 
	
	@Column(length = 100, nullable = false)
	String userId;

	@Column(nullable = false)
	int month;
	
	@Column(nullable = true)
	int water;
	
	@Column(nullable = true)
	int electric;
	
	@Column(nullable = true)
	int maintenance;
	
}

