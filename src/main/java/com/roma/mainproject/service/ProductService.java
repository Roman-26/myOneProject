package com.roma.mainproject.service;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.model.Product;
import com.roma.mainproject.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findOne(Long id);
    List<Product> findAll();
    List<Product> findAll(Pageable pageable);
    void saveNewProduct(ProductDTO productDTO);
    void delete(Long id);

    List<Product> findAll(User user);
   Optional<Product>findById(Long id);
}
