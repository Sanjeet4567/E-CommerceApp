package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Rating;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {
    public Rating createRating(RatingRequest req, User user)throws ProductException;

    public List<Rating> getproductsrating(Long productId);

}
