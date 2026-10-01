package com.codominator.orderservice.service;

import com.codominator.orderservice.dto.OrderRequest;
import com.codominator.orderservice.dto.OrderResponse;
import com.codominator.orderservice.entity.Order;
import com.codominator.orderservice.repository.OrderRepository;
import com.codominator.orderservice.utils.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order entity = OrderMapper.toEntity(orderRequest);
        Order createOrder = orderRepository.save(entity);
        return OrderMapper.toResponse(createOrder);
    }

    public List<OrderResponse> getAllOrder(String customerId) {

        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .map(OrderMapper::toResponse)
                .toList();
    }
}
