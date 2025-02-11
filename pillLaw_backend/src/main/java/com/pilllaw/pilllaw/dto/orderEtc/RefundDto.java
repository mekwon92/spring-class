package com.pilllaw.pilllaw.dto.orderEtc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import com.pilllaw.pilllaw.entity.orderEtc.RefundStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RefundDto {
  private Long rno;
  private Long mno; 
  private Long ono; 
  private long amount;
  private String reason;
  private String method;
  private RefundStatus refundStatus;
  private LocalDateTime regdate;
  private LocalDateTime moddate;
}
