package com.zerno.entity.order;

import com.zerno.type.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shipments",
        indexes = {
                @Index(name = "idx_shipment_order", columnList = "order_id"),
                @Index(name = "idx_shipment_status", columnList = "status")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each shipment belongs to one order
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    private String carrier;          // e.g., "FedEx", "BlueDart"
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @CreationTimestamp
    private LocalDateTime shippedAt;

    private LocalDateTime deliveredAt;

    // One shipment can include multiple order items
    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShipmentItem> shipmentItems = new HashSet<>();
}
