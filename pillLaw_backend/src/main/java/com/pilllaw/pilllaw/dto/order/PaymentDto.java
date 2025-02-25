package com.pilllaw.pilllaw.dto.order;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDto {
  private Long payno; // 결제 번호
  private Long ono; // 주문 번호
  private int amount; // 결제 금액
  private String method; // 결제 방법 (예: 카드, 계좌이체 등)
  private String cardName; // 카드사 이름
  private String cardNumber; // 카드 번호
  private String transactionId; // 결제 시스템에서 발급한 거래 ID
  private LocalDateTime paymentDate; // 결제 날짜

  private String impUid; // Iamport에서 받은 거래 ID
  private String merchantUid; // Iamport에서 받은 상점 거래 ID
  private String status; // 결제 상태 (예: 성공, 실패)
  
  private String paymentStatus; // 결제 상태 (Enum -> String 변환)
  private LocalDateTime regdate, moddate;
}
