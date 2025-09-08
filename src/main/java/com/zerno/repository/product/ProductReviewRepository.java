package com.zerno.repository.product;

import com.zerno.entity.product.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    // Find all reviews for a specific product
    List<ProductReview> findByProductId(Long productId);

    // Find all reviews written by a specific user
    List<ProductReview> findByUserId(Long userId);

    // Find a review for a product by a specific user (unique constraint)
    Optional<ProductReview> findByProductIdAndUserId(Long productId, Long userId);

    // Count reviews for a product
    long countByProductId(Long productId);

    // Count reviews by a user
    long countByUserId(Long userId);
}
