package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.community.entity.Community;
import com.example.demo.community.repository.CommunityRepository;
import com.example.demo.member.entity.Member;

@SpringBootTest
public class CommunityRepositoryTest {

	
	@Autowired
	CommunityRepository repository;
	
	@Test
	void 모임게시글등록() {
		Member member = Member.builder().userId("2").build();
		
		Community community1 = Community.builder().title("맛집모임입니다").content("맛집모임입니다").writer("원석").category("맛집").build();
		repository.save(community1);
		Community community2 = Community.builder().title("운동모임입니다").content("운동모임입니다").writer("석준").category("운동").build();
		repository.save(community2);
		Community community3 = Community.builder().title("등산모임입니다").content("등산모임입니다").writer("준호").category("등산").build();
		repository.save(community3);
		Community community4 = Community.builder().title("독서모임입니다").content("독서모임입니다").writer("경환").category("독서").build();
		repository.save(community4);
	}
}






