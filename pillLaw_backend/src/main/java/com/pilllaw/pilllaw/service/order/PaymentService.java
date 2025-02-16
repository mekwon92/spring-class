package com.pilllaw.pilllaw.service.order;

import java.util.List;

import com.pilllaw.pilllaw.dto.order.CartItemDto;

public interface PaymentService {
    public void processOrderItems(Long ono, List<CartItemDto> cartItems);
}
