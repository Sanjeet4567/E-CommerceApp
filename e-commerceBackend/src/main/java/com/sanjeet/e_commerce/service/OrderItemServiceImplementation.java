package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.model.OrderItem;
import com.sanjeet.e_commerce.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemServiceImplementation implements  OrderItemService{
    OrderItemRepository repository;
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return repository.save(orderItem);
    }
}
