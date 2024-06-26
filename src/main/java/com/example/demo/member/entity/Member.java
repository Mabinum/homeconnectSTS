package com.example.demo.member.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Member extends BaseEntity  {
	
	@Id
	@Column(length = 100)
	String userId;

	@Column(length = 255, nullable = false)
	String pw;

	@Column(length = 100, nullable = false)
	String name;
	
	@Column(length = 100, nullable = false)
	LocalDate birthdate;
	
	@Column(length = 100, nullable = false)
	String sex;
	
	@Column(length = 100, nullable = false)
	int phonenumber;
	
	@Column(length = 255, nullable = false)
	String address;
	
	@Column(length = 100, nullable = false)
	String dong;
	
	@Column(length = 100, nullable = false)
	String hosu;

	@Column(length = 100, nullable = false)
	String role;
}
