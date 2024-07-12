//package com.example.demo.fee.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.fee.dto.PayDTO;
//import com.example.demo.fee.service.PayService;
//
//@Controller
//@RequestMapping("/pay")
//public class PayController {
//	
//	@Autowired
//    PayService payService;
//	
//	@PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody PayDTO pay) {
//        String merchant_uid = payService.register(pay);
//        return new ResponseEntity<>(merchant_uid, HttpStatus.CREATED); 
//    }
//	
//	@GetMapping("/read")
//    public ResponseEntity<PayDTO> read(@RequestParam(name = "merchant_uid") String merchant_uid) {
//        PayDTO pay = payService.read(merchant_uid);
//        if (pay != null) {
//            return new ResponseEntity<>(pay, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 에러 코드 반환
//        }
//    }
//	
//	@GetMapping("/list")
//    public ResponseEntity<List<PayDTO>> getList() {
//        List<PayDTO> list = payService.getList();
//        return new ResponseEntity<>(list, HttpStatus.OK); // 200 성공 코드와 게시물 목록을 반환한다
//    }
////	public String insertPaymentInfo(@RequestBody PayEntity entity) {
////		// STEP5-3. 결제 정보 검증 후 저장하기
////		// 처음에 요청했던 금액 저장하기
////		try {
////			payService.insertPaymentInfo(entity);
////			return "ok";	
////		} catch(Exception e){
////			return "ng";
////		}
//	}
//	
////	@ResponseBody
////	@PostMapping("/complete")
////	public String complete(@RequestBody PaymentsModel paymentsModel) {
////		// STEP5. 결제 정보 검증 및 저장하기
////		try {
////			// STEP5-2. 결제 정보 조회하기
////			// 액세스 토큰(access token) 발급 받기
////			String accessToken = paymentsService.getAccessToken(paymentsModel); 
////			// imp_uid로 아임포트 서버에서 결제 정보 조회
////			PaymentsModel paymentInfo = paymentsService.getPaymentInfo(accessToken, paymentsModel);
////			// STEP5-3. 결제 정보 검증 후 저장하기
////			// DB에서 결제되어야 하는 금액 조회
////			String amountToBePaid = paymentsService.getAmountToBePaid(paymentsModel);
////			int amount = paymentInfo.getAmount();
////			// 결제 검증하기
////			if(Integer.parseInt(amountToBePaid) == amount) {
////				paymentsService.updatePaymentInfo(paymentInfo); // DB에 결제 정보 저장
////				if(paymentInfo.getStatus().equals("paid")) { // 결제 완료
////					return "success";
////				}else if(paymentInfo.getStatus().equals("ready")) { // 가상계좌발급
////					return "vbankIssued";
////				}else {
////					return "fail";
////				}
////			}else { // 결제금액 불일치. 위/변조 된 결제
////				return "forgery";
////			}
////		}catch(Exception e) {
////			return "exception";
////		}
////	}
//
