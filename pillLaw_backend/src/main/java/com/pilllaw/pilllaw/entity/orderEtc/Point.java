package com.pilllaw.pilllaw.entity.orderEtc;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.pilllaw.pilllaw.entity.BaseEntity;

@Entity(name = "tbl_point")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Point extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pono;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "mno", nullable = false)
    // private Member member;

    private long point;
    
    @Enumerated(EnumType.STRING)
    private PointStatus status;
    private LocalDateTime endDate;
}
