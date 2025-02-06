package com.sanjeet.e_commerce.repository;

import com.sanjeet.e_commerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT r from Review r where r.product.id=:productId")
    public List<Review> getAllProductsReview(@Param("productId")Long productId);
}
