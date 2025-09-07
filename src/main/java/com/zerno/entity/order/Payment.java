package com.zerno.entity.order;

import com.zerno.type.PaymentMethod;
import com.zerno.type.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments",
        indexes = {
                @Index(name = "idx_payment_order", columnList = "order_id"),
                @Index(name = "idx_payment_provider_id", columnList = "providerPaymentId")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Payment belongs to an order
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(nullable = false)
    private String provider; // e.g., Razorpay, Stripe, PayPal

    @Column(nullable = false, unique = true)
    private String providerPaymentId; // Transaction ID from provider

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency; // ISO code (INR, USD, etc.)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method; // CARD, UPI, NETBANKING, COD, etc.

    @CreationTimestamp
    private LocalDateTime createdAt;

    // One payment can have multiple refunds
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Refund> refunds = new HashSet<>();
}
