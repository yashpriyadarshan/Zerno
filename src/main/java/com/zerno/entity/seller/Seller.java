package com.zerno.entity.seller;

import com.zerno.entity.user.User;
import com.zerno.type.StatusType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Owner of the seller account
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User owner;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false, unique = true)
    private String gstNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status = StatusType.PENDING;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // One seller can have multiple stores
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Store> stores = new HashSet<>();
}
