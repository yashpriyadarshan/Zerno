package com.zerno.entity.product;

import com.zerno.type.AttributeType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attributes",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"),
        indexes = @Index(name = "idx_attribute_type", columnList = "type"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AttributeType type; // STRING, NUMBER, BOOLEAN
}
