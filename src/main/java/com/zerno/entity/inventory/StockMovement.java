package com.zerno.entity.inventory;

import com.zerno.entity.product.ProductVariant;
import com.zerno.type.MovementReason;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariant variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    // Positive or negative stock adjustment
    @Column(nullable = false)
    private Integer delta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementReason reason; // ORDER_PLACED, ORDER_CANCELLED, STOCK_ADJUSTMENT, RETURN

    private String referenceId; // e.g., Order_ID, Return_ID

    @CreationTimestamp
    private LocalDateTime createdAt;
}
