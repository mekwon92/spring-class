package com.pilllaw.pilllaw.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  Payment findByImpUid(String impUid); // impUid로 결제 정보를 찾는 예시
}