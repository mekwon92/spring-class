package com.pilllaw.pilllaw.repository.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

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
    public void testInsertCartWithItems() { 
        
        Cart savedCart = Cart.builder().member(Member.builder().mno(2L).build()).build();
        cartRepository.save(savedCart);

        CartItem ci1 = CartItem.builder().cart(savedCart).product(Product.builder().pno(1L).build()).subday(60)
                .quantity(2).build();
        CartItem ci2 = CartItem.builder().cart(savedCart).product(Product.builder().pno(2L).build()).subday(60)
                .quantity(1).build();
        CartItem ci3 = CartItem.builder().cart(savedCart).product(Product.builder().pno(3L).build()).subday(30)
                .quantity(2).build();
        CartItem ci4 = CartItem.builder().cart(savedCart).product(Product.builder().pno(4L).build()).subday(30)
                .quantity(3).build();

        savedCart.getCartItems().add(ci1);
        savedCart.getCartItems().add(ci2);
        savedCart.getCartItems().add(ci3);
        savedCart.getCartItems().add(ci4);

        cartItemRepository.saveAll(List.of(ci1, ci2, ci3, ci4));

        cartRepository.save(savedCart);

        List<CartItem> cartItems = savedCart.getCartItems();
        log.info(cartItems);
    }

    @Test
    public void testListCartItems() {
        List<CartItem> cartItems = cartItemRepository.findByCartCno(2L);
        log.info(cartItems);
    }

    @Test
    @Rollback(false)
    public void testDeleteAll() {
        cartItemRepository.deleteAllByCartCno(2L);
    }

    @Test
    @Rollback(false)
    public void testDeleteOne() {
        cartItemRepository.deleteById(17L);
    }

    @Test
    @Rollback(false) 
    public void testUpdate() {
        CartItem cartItem = cartItemRepository.findById(16L).orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItem.setQuantity(2L);
        cartItemRepository.save(cartItem);
    }

}
