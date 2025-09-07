package com.zerno.entity.product;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "variant_prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariantPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each SKU can have multiple price records over time
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariant variant;

    @Column(nullable = false, length = 3)
    private String currency; // ISO 4217 (e.g., "USD", "INR")

    @Column(nullable = false)
    private Double listPrice; // regular price

    private Double salePrice; // discounted price (nullable)

    @Column(nullable = false)
    private LocalDateTime validFrom;

    private LocalDateTime validTo;
}
