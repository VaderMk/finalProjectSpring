package org.example.finalproject.service;

import org.example.finalproject.entity.*;

import java.util.*;

public interface ProductService {

    Product createProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    void deleteAllProducts();
    void deleteById(Long id);
    Product updateById(Product product, Long id);
    Product updatePartialProduct(Product product, Long id);
}