package com.pilllaw.pilllaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.product.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    // 해당 상품의 최신 가격을 가져오는 메서드
    ProductPrice findTopByProductPnoOrderByRegdateDesc(Long pno);
  }