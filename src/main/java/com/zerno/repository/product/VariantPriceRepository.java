package com.zerno.repository.product;

import com.zerno.entity.product.VariantPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantPriceRepository extends JpaRepository<VariantPrice, Long> {
}