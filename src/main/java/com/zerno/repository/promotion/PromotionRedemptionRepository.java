package com.zerno.repository.promotion;

import com.zerno.entity.promotion.PromotionRedemption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRedemptionRepository extends JpaRepository<PromotionRedemption, Long> {

    // Find all redemptions by a specific promotion
    List<PromotionRedemption> findByPromotionId(Long promotionId);

    // Find all redemptions by a specific user
    List<PromotionRedemption> findByUserId(Long userId);

    // Find all redemptions by a specific order
    List<PromotionRedemption> findByOrderId(Long orderId);

    // Optional: find by promotion and user together
    List<PromotionRedemption> findByPromotionIdAndUserId(Long promotionId, Long userId);
}
