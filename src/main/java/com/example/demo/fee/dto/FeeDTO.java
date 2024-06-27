package com.example.demo.fee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeDTO {
	
	int no; // id
	
	int month; // 월
	
	int water; // 수도세
	
	int electric; // 전기세
	
	int maintenance; // 관리비 
}
