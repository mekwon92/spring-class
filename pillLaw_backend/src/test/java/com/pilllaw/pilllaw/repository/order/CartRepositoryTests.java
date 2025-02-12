package com.pilllaw.pilllaw.repository.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pilllaw.pilllaw.entity.member.Member;
import com.pilllaw.pilllaw.entity.order.Cart;
import com.pilllaw.pilllaw.entity.order.CartItem;
import com.pilllaw.pilllaw.entity.product.Product;
import com.pilllaw.pilllaw.repository.MemberRepository;
import com.pilllaw.pilllaw.repository.ProductRepository;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class CartRepositoryTests {
  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private CartItemRepository cartItemRepository;

  @Test
@Rollback(false)
public void testMergeCartItems() {
    // 중복되는 CartItems를 조회하여 병합하기
    List<CartItem> cartItems = cartItemRepository.findByCartCno(2L);

    // 중복 처리
    Map<String, CartItem> mergedItems = new HashMap<>();

    for (CartItem item : cartItems) {
        // 중복 기준: Cart + Product + Subday
        String key = item.getProduct().getPno() + "-" + item.getSubday();

        // 이미 존재하는 경우, quantity 합침
        if (mergedItems.containsKey(key)) {
            CartItem existingItem = mergedItems.get(key);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            mergedItems.put(key, item);
        }
    }

    // 중복된 CartItem들을 삭제하고 병합된 결과를 저장
    for (CartItem item : cartItems) {
        // 삭제된 CartItem
        if (!mergedItems.containsKey(item.getProduct().getPno() + "-" + item.getSubday())) {
            // 해당 항목 삭제
            cartItemRepository.delete(item);
        }
    }

    // 삭제 후 flush()를 호출하여 데이터베이스에 반영
    cartItemRepository.flush();
    
    // 병합된 CartItem들을 저장
    for (CartItem item : mergedItems.values()) {
        cartItemRepository.save(item);
    }

    // 결과 확인
    List<CartItem> updatedCartItems = cartItemRepository.findByCartCno(2L);
    updatedCartItems.forEach(item -> log.info("Updated CartItem: {}", item));
}


}
