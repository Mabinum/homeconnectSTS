package com.example.demo.fee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.fee.entity.FeeEntity;

public interface FeeRepository extends JpaRepository<FeeEntity, Integer>{

}
