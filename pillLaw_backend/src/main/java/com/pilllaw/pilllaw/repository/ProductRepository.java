package com.pilllaw.pilllaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pilllaw.pilllaw.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByPno(Long pno);
}
