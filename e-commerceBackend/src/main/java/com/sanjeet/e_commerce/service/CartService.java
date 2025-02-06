package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.model.Cart;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.AddItemRequest;


public interface CartService {
    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req)throws ProductException;
    public Cart findUserCart(Long userId);
}
