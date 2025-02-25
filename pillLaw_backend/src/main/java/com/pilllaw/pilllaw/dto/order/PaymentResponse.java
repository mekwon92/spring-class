package com.pilllaw.pilllaw.dto.order;

public class PaymentResponse {
    private String status;  // "paid" 또는 "failed"
    private int amount;     // 결제 금액
    private String imp_uid; // Iamport 거래 ID
    // 기타 필요한 응답 데이터
}
  
