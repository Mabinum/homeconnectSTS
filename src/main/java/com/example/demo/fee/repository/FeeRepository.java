package com.example.demo.fee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.fee.entity.FeeEntity;

public interface FeeRepository extends JpaRepository<FeeEntity, String>{
//	integer로 변경
//	feeEntity id 임의의 값으로 변경(int no)
//	FeeId 삭제
}
