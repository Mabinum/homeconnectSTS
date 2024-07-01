package com.example.demo.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.community.entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Integer>{

}
