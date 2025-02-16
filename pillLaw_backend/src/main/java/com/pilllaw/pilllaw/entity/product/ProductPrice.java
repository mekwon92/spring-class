package com.pilllaw.pilllaw.entity.product;

import com.pilllaw.pilllaw.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_product_price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductPrice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ppno") // 기존 price_id 컬럼을 ppno로 변경
    private Long ppno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pno", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long price;

    private Long salePrice;
}