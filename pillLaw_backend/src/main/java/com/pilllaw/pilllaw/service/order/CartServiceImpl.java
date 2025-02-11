package com.pilllaw.pilllaw.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilllaw.pilllaw.dto.order.CartDto;
import com.pilllaw.pilllaw.entity.order.Cart;
import com.pilllaw.pilllaw.repository.MemberRepository;
import com.pilllaw.pilllaw.repository.ProductRepository;
import com.pilllaw.pilllaw.repository.order.CartRepository;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Service
@Data
@Log4j2
public class CartServiceImpl implements CartService {
  @Autowired
  private MemberRepository memberRepository;
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CartRepository cartRepository;
  
  
  @Override
  public void addProductToCart(Long cno, Long pno, int quantity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public CartDto createCart(Long mno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteCart(Long cno) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public CartDto getCartByMemberId(Long mno) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void removeProductFromCart(Long cno, Long pno) {
    // TODO Auto-generated method stub
    
  }
  


  
}