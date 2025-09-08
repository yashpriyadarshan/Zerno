package com.zerno.repository.product;

import com.zerno.entity.product.Product;
import com.zerno.type.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by status (e.g., PUBLISHED, DRAFT)
    List<Product> findByStatus(ProductStatus status);

    // Search products by title (case-insensitive contains)
    List<Product> findByTitleContainingIgnoreCase(String title);

    // Fetch all products belonging to a specific category
    List<Product> findByCategories_Id(Long categoryId);

    // Find recently created products (e.g., last N sorted by createdAt)
    List<Product> findTop10ByOrderByCreatedAtDesc();
}
