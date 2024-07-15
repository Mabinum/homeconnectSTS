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
public class PayDTO {

	String imp_uid;
	
	String merchant_uid;
	
	int amount;
	
	String month;
	
	String buyer_name; // 이름
	
    String email; // 이메일
    
    String card_name; // 카드이름
    
    String time; // 결제시간
}
