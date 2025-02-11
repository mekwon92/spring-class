package com.pilllaw.pilllaw.service.order;

import com.pilllaw.pilllaw.dto.order.CartDto;

public interface CartService {
  CartDto getCartByMemberId(Long mno);
  CartDto createCart(Long mno);
  void addProductToCart(Long cno, Long pno, int quantity);
  void removeProductFromCart(Long cno, Long pno);
  void deleteCart(Long cno);
}