package com.example.demo.member.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity  {
	
	@Id
	@Column(length = 100)
	String userId;

	@Column(length = 255, nullable = false)
	String pw;

	@Column(length = 100, nullable = false)
	String name;
	
	@Column(length = 100)
	LocalDate birthdate;
	
	@Column(length = 100)
	String sex;
	
	@Column(length = 255)
	String address;

	@Column(length = 100, nullable = false)
	String role;
	
	 @ElementCollection
	    private List<Integer> communityNos;

	    public List<Integer> getCommunityNos() {
	        return communityNos;
	    }

	    public void setCommunityNos(List<Integer> communityNos) {
	        this.communityNos = communityNos;
	    }
}
