package com.tecnoshop.createProducts.repository;

import com.tecnoshop.createProducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySkuAndDeletedAtIsNull(String sku);

}
