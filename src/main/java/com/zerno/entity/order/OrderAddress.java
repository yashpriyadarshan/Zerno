package com.zerno.entity.order;

import com.zerno.type.AddressType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_addresses", indexes = {
        @Index(name = "idx_order_address_order", columnList = "order_id"),
        @Index(name = "idx_order_address_type", columnList = "addressType")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which order this address belongs to
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AddressType addressType; // SHIPPING or BILLING

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String line1;

    private String line2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String country;
}
