package com.example.demo.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.fee.dto.FeeDTO;
import com.example.demo.fee.service.FeeService;

@RestController
@RequestMapping("/fee")
public class FeeController {
	
	@Autowired
	private FeeService feeService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody FeeDTO fee) {
        String userId = feeService.register(fee);
        return new ResponseEntity<>(userId, HttpStatus.CREATED); // 201 성공 코드와 새로운 글번호를 반환한다
    }

    @GetMapping("/list")
    public ResponseEntity<List<FeeDTO>> getList(@RequestParam(name = "userId") String userId) {
        List<FeeDTO> list = feeService.getListByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK); // 200 성공 코드와 게시물 목록을 반환한다
    }

    @GetMapping("/read")
    public ResponseEntity<FeeDTO> read(@RequestParam(name = "userId") String userId) {
        FeeDTO fee = feeService.read(userId);
        if (fee != null) {
            return new ResponseEntity<>(fee, HttpStatus.OK); // 200 성공 코드와 게시물 정보를 반환한다
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 에러 코드 반환
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<Void> modify(@RequestBody FeeDTO fee) {
        feeService.modify(fee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 성공 코드를 반환한다
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestParam(name = "userId") String userId) {
        feeService.remove(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 성공 코드를 반환한다
    }
}