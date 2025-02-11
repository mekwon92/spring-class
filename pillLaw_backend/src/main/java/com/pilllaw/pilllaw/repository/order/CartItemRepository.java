package com.pilllaw.pilllaw.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
  List<CartItem> findByCartCno(Long cno);
}