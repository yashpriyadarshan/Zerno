package com.zerno.entity.product;

import com.zerno.type.VariantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_variants",
        indexes = {
                @Index(name = "idx_variant_sku", columnList = "sku"),
                @Index(name = "idx_variant_product", columnList = "product_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Currency currency;

    private Double weight;

    private String dimensions;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VariantStatus status = VariantStatus.ACTIVE;

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VariantAttributeValue> attributeValues = new HashSet<>();

    @OneToMany(mappedBy = "variant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VariantPrice> prices = new HashSet<>();
}
