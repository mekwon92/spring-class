package com.pilllaw.pilllaw.entity.product;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

import com.pilllaw.pilllaw.entity.BaseEntity;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column(nullable = false, length = 500)
    private String pname;

    @Column(nullable = false, length = 500)
    private String company;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date bestBefore;

    @Column(nullable = false, length = 500)
    private String effect;

    @Column(nullable = false, length = 500)
    private String precautions;

    @Column(nullable = false, length = 500)
    private String keep;

    @Column(nullable = false, length = 500)
    private String cname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type;

    public enum ProductType {
        일반, 구독_전용, 패키지, 얼리버드
    }
}