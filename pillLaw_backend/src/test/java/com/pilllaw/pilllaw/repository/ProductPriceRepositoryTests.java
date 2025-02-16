package com.pilllaw.pilllaw.repository;

import com.pilllaw.pilllaw.PilllawApplication;
import com.pilllaw.pilllaw.entity.product.Product;
import com.pilllaw.pilllaw.entity.product.ProductPrice;
import com.pilllaw.pilllaw.repository.ProductPriceRepository;
import com.pilllaw.pilllaw.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

@SpringBootTest(classes = PilllawApplication.class)
@Log4j2
public class ProductPriceRepositoryTests {

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Rollback(false)
    @Transactional
    public void testInsertProductPrice() {
        // ProductPrice 추가 (각각 직접 추가)
        
        // pno 1
        Product product1 = productRepository.findByPno(1L);
        ProductPrice productPrice1 = ProductPrice.builder()
            .product(product1)
            .price(12000L)
            .salePrice(11000L)
            .build();
        productPriceRepository.save(productPrice1);
        log.info("Inserted ProductPrice for Product pno 1: " + productPrice1);
    
        // pno 2
        Product product2 = productRepository.findByPno(2L);
        ProductPrice productPrice2 = ProductPrice.builder()
            .product(product2)
            .price(15000L)
            .salePrice(14000L)
            .build();
        productPriceRepository.save(productPrice2);
        log.info("Inserted ProductPrice for Product pno 2: " + productPrice2);
    
        // pno 3
        Product product3 = productRepository.findByPno(3L);
        ProductPrice productPrice3 = ProductPrice.builder()
            .product(product3)
            .price(18000L)
            .salePrice(17000L)
            .build();
        productPriceRepository.save(productPrice3);
        log.info("Inserted ProductPrice for Product pno 3: " + productPrice3);
    
        // pno 4
        Product product4 = productRepository.findByPno(4L);
        ProductPrice productPrice4 = ProductPrice.builder()
            .product(product4)
            .price(20000L)
            .salePrice(19000L)
            .build();
        productPriceRepository.save(productPrice4);
        log.info("Inserted ProductPrice for Product pno 4: " + productPrice4);
    
        // pno 5
        Product product5 = productRepository.findByPno(5L);
        ProductPrice productPrice5 = ProductPrice.builder()
            .product(product5)
            .price(22000L)
            .salePrice(21000L)
            .build();
        productPriceRepository.save(productPrice5);
        log.info("Inserted ProductPrice for Product pno 5: " + productPrice5);
    
        // pno 6
        Product product6 = productRepository.findByPno(6L);
        ProductPrice productPrice6 = ProductPrice.builder()
            .product(product6)
            .price(25000L)
            .salePrice(24000L)
            .build();
        productPriceRepository.save(productPrice6);
        log.info("Inserted ProductPrice for Product pno 6: " + productPrice6);
    
        // pno 7
        Product product7 = productRepository.findByPno(7L);
        ProductPrice productPrice7 = ProductPrice.builder()
            .product(product7)
            .price(30000L)
            .salePrice(29000L)
            .build();
        productPriceRepository.save(productPrice7);
        log.info("Inserted ProductPrice for Product pno 7: " + productPrice7);
    
        // pno 8
        Product product8 = productRepository.findByPno(8L);
        ProductPrice productPrice8 = ProductPrice.builder()
            .product(product8)
            .price(35000L)
            .salePrice(34000L)
            .build();
        productPriceRepository.save(productPrice8);
        log.info("Inserted ProductPrice for Product pno 8: " + productPrice8);
    
        // pno 9
        Product product9 = productRepository.findByPno(9L);
        ProductPrice productPrice9 = ProductPrice.builder()
            .product(product9)
            .price(40000L)
            .salePrice(39000L)
            .build();
        productPriceRepository.save(productPrice9);
        log.info("Inserted ProductPrice for Product pno 9: " + productPrice9);
    
        // pno 10
        Product product10 = productRepository.findByPno(10L);
        ProductPrice productPrice10 = ProductPrice.builder()
            .product(product10)
            .price(45000L)
            .salePrice(44000L)
            .build();
        productPriceRepository.save(productPrice10);
        log.info("Inserted ProductPrice for Product pno 10: " + productPrice10);
    }
}
    
