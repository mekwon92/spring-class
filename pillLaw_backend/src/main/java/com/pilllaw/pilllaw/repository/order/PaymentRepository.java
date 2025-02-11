package com.pilllaw.pilllaw.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}