package org.example.finalproject.controller;

import org.example.finalproject.entity.*;
import org.example.finalproject.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart createCart(@RequestParam String userId){
        return cartService.createCart(userId);
    }
    @GetMapping
    public ResponseEntity<List<Cart>> getCartList(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Cart cart = cartService.getCartById(id);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }
    @PatchMapping("add/{id}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long id, @RequestBody Product product){
        Cart cart = cartService.addProductToCart(id, product);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }
    @PatchMapping("remove/{id}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long id, @RequestBody Product product){
        Cart cart= cartService.removeProductFromCart(id, product);
        if(cart == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }
}