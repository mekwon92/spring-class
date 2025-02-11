package com.pilllaw.pilllaw.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
  List<OrderItem> findByOrderOno(Long ono);
}