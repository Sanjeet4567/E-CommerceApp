package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.OrderException;
import com.sanjeet.e_commerce.model.Address;
import com.sanjeet.e_commerce.model.Order;
import com.sanjeet.e_commerce.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> usersOrderHistory(Long userId);
    public Order placedOrder(Long orderId)throws OrderException;
    public Order confirmedOrder(Long orderId)throws OrderException;
    public Order shippedOrder(Long orderId)throws OrderException;
    public Order deliveredOrder(Long orderId)throws OrderException;
    public Order cancelledOrder(Long orderId)throws OrderException;
    public List<Order> getAllOrders();
    public void deleteOrder(Long orderId)throws OrderException;



}
