package com.pilllaw.pilllaw.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilllaw.pilllaw.dto.order.CartItemDto;
import com.pilllaw.pilllaw.dto.order.PaymentDto;
import com.pilllaw.pilllaw.entity.order.OrderItem;
import com.pilllaw.pilllaw.entity.product.Product;

import lombok.RequiredArgsConstructor;

public class PaymentServiceImpl {

  // @Override
  // @Transactional
  // public void processOrderItems(Long ono, List<CartItemDto> cartItems) {
  //   Order order = orderRepository.findById(ono)
  //       .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다."));

  //   List<OrderItem> orderItems = cartItems.stream().map(cartItem -> OrderItem.builder()
  //       .order(order)
  //       .product(Product.builder().pno(cartItem.getPno()).build())
  //       .price(cartItem.getPrice())
  //       .subday(cartItem.getSubday())
  //       .quantity(cartItem.getQuantity())
  //       .build()).toList();

  //   orderItemRepository.saveAll(orderItems);
  // }

}
