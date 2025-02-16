package com.pilllaw.pilllaw.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pilllaw.pilllaw.dto.order.CartDto;
import com.pilllaw.pilllaw.dto.order.CartItemDto;
import com.pilllaw.pilllaw.entity.order.CartItem;
import com.pilllaw.pilllaw.service.order.CartItemService;
import com.pilllaw.pilllaw.service.order.CartService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

  @Autowired
  private CartService cartService;
  @Autowired
  private CartItemService cartItemService;

  // 장바구니 생성
  @PostMapping("/")
  public ResponseEntity<Long> addCart(@RequestBody CartDto cartDto) {
    Long cno = cartService.addCart(cartDto);
    return ResponseEntity.ok(cno);
  }

  // 장바구니 내역 조회(회원번호로)
  @GetMapping("/{mno}/items")
  public ResponseEntity<List<CartItemDto>> getCartItems(@PathVariable Long mno) {
    List<CartItemDto> cartItems = cartService.getItemsByMemberMno(mno);
    return ResponseEntity.ok(cartItems);
  }

  // 장바구니 아이템 추가
  @PostMapping("/{cno}/items")
  public ResponseEntity<Long> addCartItem(@PathVariable Long cno, @RequestBody CartItemDto cartItemDto) {
    Long cino = cartItemService.addCartItem(cartItemDto);
    return ResponseEntity.ok(cino);
  }

  // 장바구니 아이템 수정
  @PutMapping("/items/{cino}")
  public ResponseEntity<Integer> updateCartItem(@PathVariable Long cino, @RequestBody CartItemDto cartItemDto) {
    // cino를 통해 CartItemDto의 cno를 설정
    cartItemDto.setCino(cino);

    // cartItemService.updateCartItem()을 호출하여 업데이트
    int updated = cartItemService.updateCartItem(cartItemDto);
    return ResponseEntity.ok(updated);
  }

  // 장바구니 아이템 삭제
  @DeleteMapping("/items/{cino}")
  public ResponseEntity<Integer> removeCartItem(@PathVariable Long cino) {
    int removed = cartItemService.removeCartItem(cino);
    return ResponseEntity.ok(removed);
  }

  // 장바구니 전체 삭제
  @DeleteMapping("/{cno}")
  public ResponseEntity<Integer> removeCart(@PathVariable Long cno) {
    int removed = cartService.removeCart(cno);
    return ResponseEntity.ok(removed);
  }
}
