package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.OrderException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Address;
import com.sanjeet.e_commerce.model.Order;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.service.OrderService;
import com.sanjeet.e_commerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createdOrder(@RequestBody Address shippingAddress,
                                              @RequestHeader("Authorization")String jwt)throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        Order order=orderService.createOrder(user,shippingAddress);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> usersOrderHistory(@RequestHeader("Authorization")String jwt)throws UserException{
        User user=userService.findUserProfileByJwt(jwt);
        List<Order> orders=orderService.usersOrderHistory(user.getId());
        return new ResponseEntity<>(orders,HttpStatus.OK);

    }
    @GetMapping("/{Id}")
    public ResponseEntity<Order> findOrderById(
            @PathVariable("Id")Long orderId,
            @RequestHeader("Authorization")String jwt)throws UserException, OrderException{
        User user=userService.findUserProfileByJwt(jwt);
        Order order=orderService.findOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.ACCEPTED);
    }
}
