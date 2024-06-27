package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.fee.dto.FeeDTO;
import com.example.demo.fee.service.FeeService;

@SpringBootTest
public class FeeServiceTest {
	
	@Autowired
	FeeService service;
	
	@Test
	public void 데이터추가() {
		service.register(new FeeDTO(0, 1, 20000, 30000, 10000));
	}
	
	
}
