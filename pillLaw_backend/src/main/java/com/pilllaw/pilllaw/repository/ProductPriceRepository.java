package com.pilllaw.pilllaw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.product.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    Optional<ProductPrice> findByProductPno(Long pno);
  }