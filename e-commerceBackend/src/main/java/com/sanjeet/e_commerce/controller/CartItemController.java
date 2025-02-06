package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.CartItemException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.CartItem;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.response.ApiResponse;
import com.sanjeet.e_commerce.service.CartItemService;
import com.sanjeet.e_commerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
@AllArgsConstructor
public class CartItemController {
    private CartItemService cartItemService;
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
                                           @RequestHeader("Authorization")String jwt)throws UserException, CartItemException{
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(),cartItemId);

        ApiResponse res=new ApiResponse();
        res.setMessage("Item removed from cart");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(
            @RequestBody CartItem cartItem,
            @PathVariable Long cartItemId,
            @RequestHeader("Authorization")String jwt
    )throws UserException, CartItemException {
        User user=userService.findUserProfileByJwt(jwt);
        CartItem updatedCartItem=cartItemService.updateCartItem(user.getId(),cartItemId,cartItem);
        return new ResponseEntity<>(updatedCartItem,HttpStatus.OK);
    }
}
