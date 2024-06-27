package com.example.demo.fee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class FeeEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int no;
	
	@Column(nullable = true)
	int month;
	
	@Column(nullable = true)
	int water;
	
	@Column(nullable = true)
	int electric;
	
	@Column(nullable = true)
	int maintenance;
	
	
}
