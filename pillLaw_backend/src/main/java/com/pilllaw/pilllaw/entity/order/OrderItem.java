package com.pilllaw.pilllaw.entity.order;

import com.pilllaw.pilllaw.entity.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tbl_order_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "product")
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long oino;

  @ManyToOne
  @JoinColumn(name = "ono", nullable = false)
  private Order order;

  @ManyToOne
  @JoinColumn(name = "pno", nullable = false)
  private Product product;

  private Long price;
  private long subday;
  private long quantity;
}