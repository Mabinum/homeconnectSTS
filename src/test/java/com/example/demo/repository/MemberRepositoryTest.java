package com.example.demo.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 회원등록() {
		
		
		for(int i = 1; i<=20; i++) {
			Member member = Member.builder()
					.userId("userId"+i)
					.pw("PW"+i)
					.name("name"+i)
					.birthdate(LocalDate.of(2024, 02, 11))
					.sex("성별"+i)
					.phonenumber(010+i)
					.address("주소"+i)
					.dong("101동"+i)
					.hosu("101호"+i)
					.build();
			
			memberRepository.save(member);
		}
	}
	
}
