package com.pilllaw.pilllaw.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.order.Cart;
import com.pilllaw.pilllaw.entity.order.CartItem;
import com.pilllaw.pilllaw.entity.product.Product;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
  List<CartItem> findByCartCno(Long cno);
  CartItem findByCartAndProductAndSubday(Cart cart, Product product, long subday);
  void deleteAllByCartCno(Long cno);
}