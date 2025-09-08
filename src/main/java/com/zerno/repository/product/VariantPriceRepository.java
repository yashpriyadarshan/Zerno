package com.zerno.repository.product;

import com.zerno.entity.product.VariantPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VariantPriceRepository extends JpaRepository<VariantPrice, Long> {

    // Find all price records for a specific variant
    List<VariantPrice> findByVariantId(Long variantId);

    // Find all active prices for a variant at a given time
    List<VariantPrice> findByVariantIdAndValidFromLessThanEqualAndValidToGreaterThanEqual(
            Long variantId,
            LocalDateTime from,
            LocalDateTime to
    );
}
