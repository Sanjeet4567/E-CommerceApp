package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.exception.UserException;
import com.sanjeet.e_commerce.model.Product;
import com.sanjeet.e_commerce.model.Rating;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.repository.RatingRepository;
import com.sanjeet.e_commerce.request.RatingRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImplementation implements RatingService{
    private RatingRepository ratingRepository;
    private ProductService productService;
    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Rating rating=new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getproductsrating(Long productId) {
        return ratingRepository.getAllProductsrating(productId);
    }
}
