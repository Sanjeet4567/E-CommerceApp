package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.CartItemException;
import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Cart;
import com.sanjeet.e_commerce.model.CartItem;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.AddItemRequest;
import com.sanjeet.e_commerce.response.ApiResponse;
import com.sanjeet.e_commerce.service.CartItemService;
import com.sanjeet.e_commerce.service.CartService;
import com.sanjeet.e_commerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {
    private CartService cartService;
    private CartItemService cartItemService;
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization")String jwt)throws UserException{
        User user=userService.findUserProfileByJwt(jwt);
        Cart cart=cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req,
                                                     @RequestHeader("Authorization")String jwt)throws UserException, ProductException{
        User user=userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(),req);
        ApiResponse res=new ApiResponse();
        res.setStatus(true);
        res.setMessage("Item added to Cart");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


}
