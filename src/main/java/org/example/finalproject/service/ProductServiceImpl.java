package org.example.finalproject.service;

import org.example.finalproject.entity.*;
import org.example.finalproject.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateById(Product product, Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if(foundProduct.isPresent()) {
            Product updateProduct = foundProduct.get();
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setQuantity((product.getQuantity()));
            return productRepository.save(updateProduct);
        }
        return null;
    }

    @Override
    public Product updatePartialProduct(Product product, Long id) {
        Optional<Product> foundUser = productRepository.findById(id);
        if(foundUser.isEmpty()){
            return null;
        }
        Product existentProduct = foundUser.get();
        if(product.getName() != null){
            existentProduct.setName(product.getName());
        }
        if(product.getDescription() != null){
            existentProduct.setDescription(product.getDescription());
        }
        if(product.getPrice() != 0){
            existentProduct.setPrice(product.getPrice());
        }
        if(product.getQuantity()!= 0){
            existentProduct.setQuantity(product.getQuantity());
        }
        return existentProduct;
    }
}