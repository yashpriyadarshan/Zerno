package com.zerno.repository.promotion;

import com.zerno.entity.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // Find a promotion by its unique code
    Optional<Promotion> findByCode(String code);
}
