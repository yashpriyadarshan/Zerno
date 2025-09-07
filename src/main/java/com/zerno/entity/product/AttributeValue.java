package com.zerno.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attribute_values",
        indexes = @Index(name = "idx_attribute_value_attribute", columnList = "attribute_id"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;

    @Column(nullable = false, length = 255)
    private String value;
}
