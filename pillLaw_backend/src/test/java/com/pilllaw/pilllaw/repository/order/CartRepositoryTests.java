package com.pilllaw.pilllaw.repository.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.pilllaw.pilllaw.repository.MemberRepository;
import com.pilllaw.pilllaw.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class CartRepositoryTests {
  @Autowired
  private CartRepository cartRepository;
}
