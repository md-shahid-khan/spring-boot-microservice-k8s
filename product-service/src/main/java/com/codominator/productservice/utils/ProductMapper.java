package com.codominator.productservice.utils;


import com.codominator.productservice.dto.ProductRequest;
import com.codominator.productservice.dto.ProductResponse;
import com.codominator.productservice.entity.Product;

public final class ProductMapper {

    private ProductMapper() {
        // Prevent object creation
    }

    public static Product toEntity(ProductRequest request) {
        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}