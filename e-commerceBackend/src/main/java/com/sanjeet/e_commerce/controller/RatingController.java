package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Rating;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.RatingRequest;
import com.sanjeet.e_commerce.service.RatingService;
import com.sanjeet.e_commerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private UserService userService;
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(
            @RequestBody RatingRequest req,
            @RequestHeader("Authorization")String jwt
            )throws UserException, ProductException{
        User user=userService.findUserProfileByJwt(jwt);
        Rating rating=ratingService.createRating(req,user);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductRating(@PathVariable Long productId,
                                                         @RequestHeader("Authorization")String jwt)throws UserException,ProductException{
        User user=userService.findUserProfileByJwt(jwt);
        List<Rating> rating= ratingService.getproductsrating(productId);
        return new ResponseEntity<>(rating,HttpStatus.CREATED);
    }
}
