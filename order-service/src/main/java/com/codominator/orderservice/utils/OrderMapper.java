package com.codominator.orderservice.utils;

import com.codominator.orderservice.dto.OrderRequest;
import com.codominator.orderservice.dto.OrderResponse;
import com.codominator.orderservice.entity.Order;

import java.util.UUID;


public final class OrderMapper {

    private OrderMapper() {
    }

    public static Order toEntity(OrderRequest request) {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(request.skuCode());
        order.setQuantity(request.quantity());
        order.setPrice(request.price());
        order.setCustomerId(request.customerId());

        return order;
    }

    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getOrderNumber(),
                order.getSkuCode(),
                order.getPrice(),
                order.getCustomerId()
        );
    }
}
