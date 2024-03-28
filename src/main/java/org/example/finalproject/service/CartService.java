package org.example.finalproject.service;

import org.example.finalproject.entity.*;

import java.util.*;

public interface CartService {

    Cart createCart(String userId);
    Cart getCartById(Long id);
    List<Cart> getAllCarts();
    void deleteCartById(Long id);
    //Cart updateCartById(Long id);
    Cart addProductToCart(Long id ,Product product);
    Cart removeProductFromCart(Long id, Product product);
}
