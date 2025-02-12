package com.pilllaw.pilllaw.entity.order;

import com.pilllaw.pilllaw.entity.product.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tbl_cart_item")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cino;

  @ManyToOne
  @JoinColumn(name = "cno", nullable = false)
  private Cart cart;

  @ManyToOne
  @JoinColumn(name = "pno", nullable = false)
  private Product product;

  private long subday;
  private long quantity;
}