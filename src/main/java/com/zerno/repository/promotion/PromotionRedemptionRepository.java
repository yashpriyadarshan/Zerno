package com.zerno.repository.promotion;

import com.zerno.entity.promotion.PromotionRedemption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRedemptionRepository extends JpaRepository<PromotionRedemption, Long> {
}