package com.roma.mainproject.repository;

import com.roma.mainproject.model.Product;
import com.roma.mainproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByUser(User user);
}
