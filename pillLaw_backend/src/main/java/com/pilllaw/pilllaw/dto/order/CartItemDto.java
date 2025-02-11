package com.pilllaw.pilllaw.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItemDto {
  private Long cino;
  private Long cno;
  private Long pno;
  private long subday;
  private long quantity;
}