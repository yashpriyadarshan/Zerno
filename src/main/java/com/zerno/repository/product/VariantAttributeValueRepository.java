package com.zerno.repository.product;

import com.zerno.entity.product.VariantAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VariantAttributeValueRepository extends JpaRepository<VariantAttributeValue, Long> {

    // Find all attribute values for a specific variant
    List<VariantAttributeValue> findByVariantId(Long variantId);

    // Find a specific attribute value for a variant (unique constraint)
    Optional<VariantAttributeValue> findByVariantIdAndAttributeId(Long variantId, Long attributeId);
}
