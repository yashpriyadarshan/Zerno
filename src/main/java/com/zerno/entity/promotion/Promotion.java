package com.zerno.entity.promotion;

import com.zerno.type.PromotionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "promotions", indexes = @Index(name = "idx_promotion_code", columnList = "code"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code; // e.g., "WELCOME10"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionType type; // PERCENTAGE, FIXED, FREE_SHIPPING

    @Column(nullable = false)
    private Double value; // meaning depends on type

    @Column(nullable = false)
    private LocalDateTime startsAt;

    private LocalDateTime endsAt;

    @Column(columnDefinition = "TEXT")
    private String conditions; // e.g., "min_order_amount=500", "category=ELECTRONICS"
}
