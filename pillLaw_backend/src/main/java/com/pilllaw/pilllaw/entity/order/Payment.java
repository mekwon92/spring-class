package com.pilllaw.pilllaw.entity.order;

import java.time.LocalDateTime;

import com.pilllaw.pilllaw.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_payment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long payno;

  @OneToOne
  @JoinColumn(name = "ono", nullable = false)
  private Order order;

  private int amount;
  private String method;
  private String cardName;
  private String cardNumber;
  private String transactionId; // 결제 시스템에서 발급한 거래 ID
  private LocalDateTime paymentDate; // 결제 날짜

  private String impUid; // Iamport에서 받은 거래 ID
  private String merchantUid; // Iamport에서 받은 상점 거래 ID
  private String status; // 결제 상태 (예: 성공, 실패)

  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus = PaymentStatus.PENDING;

  public enum PaymentStatus {
    PENDING, SUCCESS, FAILED, REFUNDED
  }
}
