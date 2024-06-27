package com.example.demo.member.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class MemberDTO {
	
	String userId;
	
	String pw;
	
	String name;
	
	LocalDate birthdate;
	
	String sex;
	
	String address;
	
	String dong;
	
	String hosu;
	
	LocalDateTime regDate;

    LocalDateTime modDate;
    
    String role;
	
	
}
