package com.zerno.entity.product;

import com.zerno.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_reviews",
        uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "user_id"}), // one review per user per product
        indexes = {
                @Index(name = "idx_product_review_product", columnList = "product_id"),
                @Index(name = "idx_product_review_user", columnList = "user_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product being reviewed
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // User who wrote the review
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer rating; // 1–5

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer helpfulCount = 0;
}
