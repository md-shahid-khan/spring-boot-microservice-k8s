package com.codominator.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(Long orderId, String orderNumber, String skuCode, BigDecimal price, Integer quantity, String customerId) {
}
