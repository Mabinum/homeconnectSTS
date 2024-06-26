package com.example.demo.fee.controller;

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
public class feeController {
	
	int no; // id
	
	int water; // 수도세
	 
	int electric; // 전기세
	
	int maintenance; // 관리비
}
