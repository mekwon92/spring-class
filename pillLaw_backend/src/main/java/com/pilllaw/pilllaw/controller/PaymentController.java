package com.pilllaw.pilllaw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilllaw.pilllaw.dto.order.PaymentRequest;
import com.pilllaw.pilllaw.service.order.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/complete")
    public ResponseEntity<String> completePayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // 결제 정보를 저장하는 서비스 호출
            paymentService.savePayment(paymentRequest);
            return ResponseEntity.ok("결제 정보 저장 완료");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("결제 정보 저장 실패");
        }
    }
}