package com.roma.mainproject.service;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findOne(Long id);
    List<Product> findAll();

    void saveNewProduct(ProductDTO productDTO);
    void delete(Long id);
}
