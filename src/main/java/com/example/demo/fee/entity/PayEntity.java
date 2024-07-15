package com.example.demo.fee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pay")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayEntity {

	@Id
	@Column(length = 100)
	String merchant_uid;
	
	@Column(length = 100)
	String imp_uid;
	
	@Column
	int amount;
	
	@Column
	String month;
	
	@Column
	String buyer_name; // 이름
	
	@Column
    String email; // 이메일
    
	@Column
    String card_name; // 카드이름
    
	@Column
    String time; // 결제시간
}
