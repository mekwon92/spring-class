package com.pilllaw.pilllaw.repository.orderEtc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.orderEtc.Delivery;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  Optional<Delivery> findByOrderOno(Long ono);
}