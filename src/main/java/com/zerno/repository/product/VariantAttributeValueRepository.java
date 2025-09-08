package com.zerno.repository.product;

import com.zerno.entity.product.VariantAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantAttributeValueRepository extends JpaRepository<VariantAttributeValue, Long> {
}