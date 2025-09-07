package com.zerno.entity.order;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shipment_items",
        uniqueConstraints = @UniqueConstraint(columnNames = {"shipment_id", "order_item_id"}),
        indexes = {
                @Index(name = "idx_shipment_item_shipment", columnList = "shipment_id"),
                @Index(name = "idx_shipment_item_order_item", columnList = "order_item_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each shipment item belongs to a shipment
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    // Refers back to the order item being shipped
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @Column(nullable = false)
    private Integer quantity;
}
