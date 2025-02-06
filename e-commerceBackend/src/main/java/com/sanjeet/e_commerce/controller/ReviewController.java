package com.sanjeet.e_commerce.controller;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Review;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.ReviewRequest;
import com.sanjeet.e_commerce.service.ReviewService;
import com.sanjeet.e_commerce.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
                                               @RequestHeader("Authorization")String jwt)throws UserException, ProductException{
        User user=userService.findUserProfileByJwt(jwt);
        Review review =reviewService.createReview(req,user);
        return new ResponseEntity<>(review, HttpStatus.CREATED);

    }

    @GetMapping("/product/{productId}")

    public ResponseEntity<List<Review>> getProductReview(@PathVariable Long productId)throws UserException,ProductException{
        List<Review> reviews=reviewService.getAllReview(productId);
        return new ResponseEntity<>(reviews,HttpStatus.ACCEPTED);
    }

}
