package com.codominator.productservice.controller;

import com.codominator.productservice.dto.ProductRequest;
import com.codominator.productservice.dto.ProductResponse;

import com.codominator.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductRequest product) {
        return productService.createProduct(product);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get-all")
    public List<ProductResponse> findAllProducts() {
        return productService.getAllProduct();
    }
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
