package com.pilllaw.pilllaw.service.order;

import java.net.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilllaw.pilllaw.dto.order.CartItemDto;
import com.pilllaw.pilllaw.dto.order.PaymentRequest;
import com.pilllaw.pilllaw.dto.order.PaymentResponse;
import com.pilllaw.pilllaw.entity.order.Order;
import com.pilllaw.pilllaw.entity.order.OrderItem;
import com.pilllaw.pilllaw.entity.order.Payment;
import com.pilllaw.pilllaw.entity.product.Product;
import com.pilllaw.pilllaw.repository.order.OrderItemRepository;
import com.pilllaw.pilllaw.repository.order.OrderRepository;
import com.pilllaw.pilllaw.repository.order.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // 결제 완료 후 orderitems에 저장할 예정임~
    @Override
    @Transactional
    public void processOrderItems(Long ono, List<CartItemDto> cartItems) {
        Order order = orderRepository.findById(ono)
                .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다."));

        List<OrderItem> orderItems = Optional.ofNullable(cartItems)
                .orElse(Collections.emptyList())
                .stream()
                .map(cartItem -> OrderItem.builder()
                        .order(order)
                        .product(Product.builder().pno(cartItem.getPno()).build())
                        .price(cartItem.getPrice())
                        .subday(cartItem.getSubday())
                        .quantity(cartItem.getQuantity())
                        .build())
                .toList();

        orderItemRepository.saveAll(orderItems);

    }

    @Override
    @Transactional
    public void savePayment(PaymentRequest paymentRequest) {
    //     // 주문 조회 (결제와 연결될 주문을 조회)
    //     Order order = orderRepository.findById(paymentRequest.getOno())
    //             .orElseThrow(() -> new RuntimeException("주문이 존재하지 않습니다."));

    //     // PG사와 결제 검증 (imp_uid로 결제 결과 확인)
    //     boolean isPaymentValid = verifyPaymentWithPG(paymentRequest.getImpUid(), paymentRequest.getAmount());

    //     // 결제 엔티티 생성
    //     Payment payment = toEntity(paymentRequest, order);

    //     if (isPaymentValid) {
    //         payment.setPaymentStatus(Payment.PaymentStatus.SUCCESS); // 결제 성공
    //     } else {
    //         payment.setPaymentStatus(Payment.PaymentStatus.FAILED); // 결제 실패
    //     }

    //     // 결제 정보 저장
    //     paymentRepository.save(payment);
    // }

    // private boolean verifyPaymentWithPG(String impUid, int amount) {
    //     try {
    //         // Iamport API 호출하여 결제 정보를 확인 (imp_uid, amount 검증)
    //         String url = "https://api.iamport.kr/paid_status/" + impUid;
    //         HttpHeaders headers = new HttpHeaders();
    //         headers.set("Authorization", "Bearer " + yourIamportAccessToken); // Iamport 인증 토큰

    //         HttpEntity<String> entity = new HttpEntity<>(headers);
    //         ResponseEntity<PaymentResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, PaymentResponse.class);

    //         PaymentResponse paymentResponse = response.getBody();
    //         if (paymentResponse != null && paymentResponse.getStatus().equals("paid") && paymentResponse.getAmount() == amount) {
    //             return true; // 결제 성공
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return false; // 결제 실패
    }


    // 결제 실패 시 상태 변경 메서드 (예시)
    @Transactional
    @Override
    public void updatePaymentStatusToFailed(String impUid) {
        Payment payment = paymentRepository.findByImpUid(impUid);
        if (payment != null) {
            payment.setPaymentStatus(Payment.PaymentStatus.FAILED);
            paymentRepository.save(payment);
        }
    }

}