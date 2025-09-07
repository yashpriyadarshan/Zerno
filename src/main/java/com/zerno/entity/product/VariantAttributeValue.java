package com.zerno.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "variant_attribute_values",
        uniqueConstraints = @UniqueConstraint(columnNames = {"variant_id", "attribute_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariantAttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariant variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

    @Column(nullable = false)
    private String value;
}
