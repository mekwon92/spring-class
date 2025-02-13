package com.pilllaw.pilllaw.service.order;

import com.pilllaw.pilllaw.dto.order.CartDto;
import com.pilllaw.pilllaw.dto.order.CartItemDto;
import com.pilllaw.pilllaw.entity.order.Cart;
import com.pilllaw.pilllaw.entity.order.CartItem;
import com.pilllaw.pilllaw.entity.product.ProductPrice;
import com.pilllaw.pilllaw.repository.order.CartRepository;
import com.pilllaw.pilllaw.repository.order.CartItemRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Log4j2
public class CartServiceTests {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    // 테스트: Cart 생성
    @Test
    @Transactional
    @Rollback(false)
    public void testAddCart() {
        // CartDto를 생성하여 새로운 장바구니 추가
        CartDto cartDto = CartDto.builder()
                .mno(3L)  // 회원 번호
                .build();
        Long cno = cartService.addCart(cartDto);
        log.info("cno: " + cno);
    }

    // 테스트: CartItem 추가
    @Test
    @Transactional
    @Rollback(false)
    public void testAddCartItem() {
       
        // CartItem을 추가
        CartItemDto ciDto = CartItemDto.builder().cno(7L).pno(5L).quantity(2).build();
        
        // CartItemService를 통해 아이템을 추가
        Long cino = cartItemService.addCartItem(ciDto); 
        log.info("cino: " + cino);
    }
    
    // 테스트: Cart에 포함된 CartItem 목록 조회
    @Test
    @Transactional
    public void testGetItemsByMemberMno() {
        List<CartItemDto> cartItems = cartService.getItemsByMemberMno(3L);
        cartItems.forEach(cartItem -> log.info("ITEM LIST " + cartItem.toString()));
    }


    // 테스트: 회원의 Cart 조회
    @Test
    @Transactional
    public void testGetCartByMember() {
        CartDto cartDto = cartService.getCartByMember(1L).orElseThrow(() -> new RuntimeException("Cart not found"));
        log.info("Cart for member: " + cartDto);
    }


    // 테스트: Cart 삭제
    @Test
    @Transactional
    @Rollback(false)
    public void testRemoveCart() {
        cartService.removeCart(6L);  // 삭제할 Cart 번호
        log.info("Cart with id 6 removed");
    }
}
