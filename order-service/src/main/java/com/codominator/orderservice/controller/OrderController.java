package com.codominator.orderservice.controller;

import com.codominator.orderservice.dto.OrderRequest;
import com.codominator.orderservice.dto.OrderResponse;
import com.codominator.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<OrderResponse> getOrderByCustomerId(@RequestParam String customerId) {
        return orderService.getAllOrder(customerId);
    }
    @GetMapping("/health")
    public String health(){
        return "OK";
    }

}
