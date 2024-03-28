package org.example.finalproject.service;

import org.example.finalproject.entity.*;
import org.example.finalproject.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Cart createCart(String userId) {
        Optional<User> optionalUser = userRepository.findById(Long.parseLong(userId));
        if(optionalUser.isEmpty()){
            return null;
        }
        Cart cart =  new Cart();

        cart.setUser(optionalUser.get());
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }

   /* @Override
    public Cart updateCartById(Long id) {
        return null;
    }*/

    @Override
    public Cart addProductToCart(Long id, Product product) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isEmpty()) {
            return null;
        }

        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isEmpty()){
            return null;
        }

        optionalCart.get().getProductList().add(product);
        return  cartRepository.save(optionalCart.get());
    }
    @Override
    public Cart removeProductFromCart(Long id, Product product) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isEmpty()){
            return null;
        }
        Optional<Product> removeProduct = productRepository.findById(product.getId());
        if(removeProduct.isEmpty()){
            return null;
        }
        optionalCart.get().getProductList().remove(removeProduct.get());
        return cartRepository.save(optionalCart.get());
    }
}