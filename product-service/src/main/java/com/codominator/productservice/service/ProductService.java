package com.codominator.productservice.service;

import com.codominator.productservice.dto.ProductRequest;
import com.codominator.productservice.dto.ProductResponse;
import com.codominator.productservice.entity.Product;
import com.codominator.productservice.repository.ProductRepository;
import com.codominator.productservice.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product entity = ProductMapper.toEntity(productRequest);
        log.info("Creating product with id {} name {} description {} price {}", entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());

        Product createdProduct = productRepository.save(entity);

        log.info("Created product with id {} name {} description {} price {}", createdProduct.getId(), createdProduct.getName(), createdProduct.getDescription(), createdProduct.getPrice());

        return ProductMapper.toResponse(createdProduct);

    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }
}
