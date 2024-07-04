package com.example.demo.fee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.fee.entity.PayEntity;

public interface PayRepository extends JpaRepository<PayEntity, String>{

}
