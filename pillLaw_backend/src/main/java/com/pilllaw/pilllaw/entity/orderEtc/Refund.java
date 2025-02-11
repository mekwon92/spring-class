package com.pilllaw.pilllaw.entity.orderEtc;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.pilllaw.pilllaw.entity.BaseEntity;
import com.pilllaw.pilllaw.entity.order.Order;

@Entity(name = "tbl_refund")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Refund extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "mno", nullable = false)
    // private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ono", nullable = false)
    private Order order;

    private int amount;
    private String reason;
    private String method;
    
    @Enumerated(EnumType.STRING)
    private RefundStatus refundStatus;
    
}
