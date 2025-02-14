package com.pilllaw.pilllaw.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilllaw.pilllaw.dto.order.OrderItemDto;
import com.pilllaw.pilllaw.entity.order.OrderItem;
import com.pilllaw.pilllaw.repository.order.OrderItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
  @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Long createOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = toEntity(orderItemDto);
        return orderItemRepository.save(orderItem).getOino();
    }

    @Override
    public List<OrderItemDto> getOrderItemsByOrder(Long ono) {
        return orderItemRepository.findByOrderOno(ono).stream().map(this::toDto).toList();
    }

    @Override
    public void removeOrderItem(Long oino) {
        orderItemRepository.deleteById(oino);
    }
}
