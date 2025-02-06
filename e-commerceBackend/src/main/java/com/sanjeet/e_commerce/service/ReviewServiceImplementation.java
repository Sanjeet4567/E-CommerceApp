package com.sanjeet.e_commerce.service;

import com.sanjeet.e_commerce.exception.ProductException;
import com.sanjeet.e_commerce.model.Product;
import com.sanjeet.e_commerce.model.Review;
import com.sanjeet.e_commerce.model.User;
import com.sanjeet.e_commerce.repository.ProductRepository;
import com.sanjeet.e_commerce.repository.ReviewRepository;
import com.sanjeet.e_commerce.request.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImplementation implements ReviewService{
    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;
    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Review review=new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
