package com.codominator.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, String orderNumber, String skuCode, BigDecimal price, String customerId) {
}
