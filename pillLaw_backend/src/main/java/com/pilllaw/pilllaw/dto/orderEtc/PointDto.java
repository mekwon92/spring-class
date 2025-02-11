package com.pilllaw.pilllaw.dto.orderEtc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import com.pilllaw.pilllaw.entity.orderEtc.PointStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PointDto {
  private Long pono;
  private Long mno; 
  private long point;
  private PointStatus status;
  private LocalDateTime endDate;
  private LocalDateTime regdate;
  private LocalDateTime moddate;
}
