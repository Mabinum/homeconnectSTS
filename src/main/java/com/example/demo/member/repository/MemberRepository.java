package com.example.demo.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.member.entity.Member;

import jakarta.transaction.Transactional;

@Transactional
public interface MemberRepository extends JpaRepository<Member,String >{
	Optional<Member> findByUserId(String userId);
	
	void deleteByUserId(String userId);
	
	List<Member> findByCommunityNo(Integer communityNo);

}
