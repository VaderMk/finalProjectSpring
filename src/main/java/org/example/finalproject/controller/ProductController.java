package org.example.finalproject.controller;

import org.example.finalproject.entity.*;
import org.example.finalproject.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProductEndpoint(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByIdEndpoint(@PathVariable Long id){
        if(productService.getProductById(id).isEmpty())
            return ResponseEntity.notFound().build();
        else{
            return ResponseEntity.ok(productService.getProductById(id).get());
        }
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProductsEndpoint(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @DeleteMapping
    public void deleteAllProductsEndpoint(){
        productService.deleteAllProducts();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserByIdEndpoint(@PathVariable Long id){
        if(productService.getProductById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable Long id, @RequestBody Product product){
        if(productService.getProductById(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productService.updateById(product, id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updatePartialUser(@PathVariable Long id, @RequestBody Product product){
        if(productService.getProductById(id).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productService.updatePartialProduct(product, id));
    }
}