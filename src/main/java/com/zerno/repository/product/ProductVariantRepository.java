package com.zerno.repository.product;

import com.zerno.entity.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    // Find variant by SKU
    Optional<ProductVariant> findBySku(String sku);

    // Check if a variant exists by SKU
    boolean existsBySku(String sku);

    // Find all variants of a specific product
    List<ProductVariant> findByProductId(Long productId);

    // Find all variants by status
    List<ProductVariant> findByStatus(Enum status);

    // Custom delete by SKU
    void deleteBySku(String sku);
}
