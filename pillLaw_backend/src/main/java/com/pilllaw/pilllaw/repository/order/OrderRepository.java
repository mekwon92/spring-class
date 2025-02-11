package com.pilllaw.pilllaw.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  // List<Order> findByMemberMno(Long mno);
}