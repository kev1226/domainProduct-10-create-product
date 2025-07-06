package com.tecnoshop.createProducts.service;

import com.tecnoshop.createProducts.dto.ProductDTO;
import com.tecnoshop.createProducts.model.Product;
import com.tecnoshop.createProducts.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(ProductDTO dto) {
        repo.findBySkuAndDeletedAtIsNull(dto.getSku()).ifPresent(p -> {
            throw new IllegalArgumentException("SKU ya registrado.");
        });
        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        p.setSku(dto.getSku());
        p.setIsPublished(dto.getIsPublished());
        return repo.save(p);
    }

}