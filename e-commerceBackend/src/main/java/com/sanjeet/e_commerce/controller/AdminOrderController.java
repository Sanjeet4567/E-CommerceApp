package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.OrderException;
import com.sanjeet.e_commerce.model.Order;
import com.sanjeet.e_commerce.response.ApiResponse;
import com.sanjeet.e_commerce.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
@AllArgsConstructor
public class AdminOrderController {
    private OrderService orderService;
    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandle(){
        List<Order> orders=orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
    }
    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> ConfirmedOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization")String jwt
    )throws OrderException{
        Order order=orderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> ShippedOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization")String jwt
    )throws OrderException{
        Order order=orderService.shippedOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/delivered")
    public ResponseEntity<Order> DeliveredOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization")String jwt
    )throws OrderException{
        Order order=orderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> CancelledOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization")String jwt
    )throws OrderException{
        Order order=orderService.cancelledOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> DeleteOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader("Authorization")String jwt
    )throws OrderException{
        orderService.deleteOrder(orderId);
        ApiResponse res=new ApiResponse();
        res.setMessage("Order Deleted Successfully");
        res.setStatus(true);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
