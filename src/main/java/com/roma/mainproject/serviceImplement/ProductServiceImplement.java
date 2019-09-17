package com.roma.mainproject.serviceImplement;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.model.Product;
import com.roma.mainproject.model.User;
import com.roma.mainproject.repository.ProductRepository;
import com.roma.mainproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findOne(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Product> findAll(User user) {
        return productRepository.findAllByUser(user);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveNewProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setAmount(productDTO.getAmount());
        product.setManufacturer(productDTO.getManufacturer());
        product.setUser(productDTO.getUser());
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
