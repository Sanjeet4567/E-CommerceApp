package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.model.Review;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user)throws ProductException;
    public List<Review> getAllReview(Long productId);
}
