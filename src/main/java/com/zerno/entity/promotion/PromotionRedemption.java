package com.zerno.entity.promotion;

import com.zerno.entity.order.Order;
import com.zerno.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "promotion_redemptions",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"promotion_id", "user_id", "order_id"},
                name = "uk_promotion_user_order"
        )
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionRedemption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which promotion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;

    // Which user used it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Which order it applied to
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @CreationTimestamp
    private LocalDateTime redeemedAt;
}
