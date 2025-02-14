package com.pilllaw.pilllaw.service.order;

import java.util.List;

import com.pilllaw.pilllaw.dto.order.OrderItemDto;
import com.pilllaw.pilllaw.entity.order.Order;
import com.pilllaw.pilllaw.entity.order.OrderItem;
import com.pilllaw.pilllaw.entity.product.Product;

public interface OrderItemService {
  Long createOrderItem(OrderItemDto orderItemDto);
  List<OrderItemDto> getOrderItemsByOrder(Long ono);
  void removeOrderItem(Long oino);

  // DTO -> Entity 변환
  default OrderItem toEntity(OrderItemDto orderItemDto) {
      return OrderItem.builder()
              .oino(orderItemDto.getOino())
              .order(Order.builder().ono(orderItemDto.getOno()).build())
              .product(Product.builder().pno(orderItemDto.getPno()).build())
              .price(orderItemDto.getPrice())
              .subday(orderItemDto.getSubday())
              .quantity(orderItemDto.getQuantity())
              .build();
  }

  // Entity -> DTO 변환
  default OrderItemDto toDto(OrderItem orderItem) {
      return OrderItemDto.builder()
              .oino(orderItem.getOino())
              .ono(orderItem.getOrder().getOno())
              .pno(orderItem.getProduct().getPno())
              .price(orderItem.getPrice())
              .subday(orderItem.getSubday())
              .quantity(orderItem.getQuantity())
              .build();
  }
}
