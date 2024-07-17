package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.fee.entity.FeeEntity;
import com.example.demo.fee.repository.FeeRepository;

@SpringBootTest
public class FeeRepositoryTest {

	@Autowired
	FeeRepository repository;
	
	@Test
	void user1관리비등록() {
		for(int i = 1; i < 13; i++) {
			FeeEntity fee = FeeEntity.builder()
					.userId("user1")
					.month(i)
					.electric(10000)
					.water(20000)
					.maintenance(30000)
					.build();
			repository.save(fee);	
		}
	}
	
	@Test
	void user2관리비등록() {
		for(int i = 1; i < 13; i++) {
			FeeEntity fee = FeeEntity.builder()
					.userId("user2")
					.month(i)
					.electric(20000)
					.water(30000)
					.maintenance(10000)
					.build();
			repository.save(fee);	
		}
	}
	
	@Test
	void user3관리비등록() {
		for(int i = 1; i < 13; i++) {
			FeeEntity fee = FeeEntity.builder()
					.userId("user3")
					.month(i)
					.electric(30000)
					.water(40000)
					.maintenance(5000)
					.build();
			repository.save(fee);	
		}
	}
}
