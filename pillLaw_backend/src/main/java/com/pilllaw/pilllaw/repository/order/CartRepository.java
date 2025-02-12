package com.pilllaw.pilllaw.repository.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
  Optional<Cart> findByMemberMno(Long mno);
}