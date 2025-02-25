package com.pilllaw.pilllaw.service.order;

import java.util.List;

import com.pilllaw.pilllaw.dto.order.CartItemDto;
import com.pilllaw.pilllaw.dto.order.PaymentDto;
import com.pilllaw.pilllaw.dto.order.PaymentRequest;
import com.pilllaw.pilllaw.entity.order.Order;
import com.pilllaw.pilllaw.entity.order.Payment;

public interface PaymentService {
    public void processOrderItems(Long ono, List<CartItemDto> cartItems);
    public void savePayment(PaymentRequest paymentRequest);
    public void updatePaymentStatusToFailed(String impUid);


    default Payment toEntity(PaymentRequest paymentRequest, Order order) {
        return Payment.builder()
                .order(order) // 실제 조회된 Order 객체 연결
                .amount(paymentRequest.getAmount())
                .method(paymentRequest.getMethod())
                .cardName(paymentRequest.getCardName())
                .cardNumber(paymentRequest.getCardNumber())
                .transactionId(paymentRequest.getTransactionId())
                .paymentDate(paymentRequest.getPaymentDate())
                .impUid(paymentRequest.getImpUid())  // Iamport에서 받은 거래 ID
                .merchantUid(paymentRequest.getMerchantUid())  // Iamport에서 받은 상점 거래 ID
                .status(paymentRequest.getStatus())  // 결제 상태
                .paymentStatus(Payment.PaymentStatus.valueOf(paymentRequest.getStatus().toUpperCase()))  // 결제 상태
                .build();
    }

    default PaymentDto toDto(Payment payment) {
        return PaymentDto.builder()
                .payno(payment.getPayno())
                .ono(payment.getOrder().getOno()) // 주문 번호
                .amount(payment.getAmount())
                .method(payment.getMethod())
                .cardName(payment.getCardName())
                .cardNumber(payment.getCardNumber())
                .paymentStatus(payment.getPaymentStatus().name()) // Enum -> String 변환
                .paymentDate(payment.getPaymentDate())
                .transactionId(payment.getTransactionId())
                .impUid(payment.getImpUid()) // Iamport에서 받은 거래 ID
                .merchantUid(payment.getMerchantUid()) // Iamport에서 받은 상점 거래 ID
                .status(payment.getStatus()) // 결제 상태
                .regdate(payment.getRegdate())
                .moddate(payment.getModdate())
                .build();
    }
}
