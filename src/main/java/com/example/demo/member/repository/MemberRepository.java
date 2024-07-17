package com.example.demo.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.member.entity.Member;

import jakarta.transaction.Transactional;

@Transactional
public interface MemberRepository extends JpaRepository<Member,String >{
	Optional<Member> findByUserId(String userId);
	
	void deleteByUserId(String userId);
	

	Optional<Member> findByCommunityNo(String communityNo);

    @Modifying
    @Query("UPDATE Member m SET m.communityNo = :communityNo WHERE m.userId = :userId")
    void updateCommunityNoByUserId(@Param("communityNo") String communityNo, @Param("userId") String userId);
    
	
}
