package com.zerno.entity.system;

import com.zerno.entity.user.User;
import com.zerno.type.GDPRRequestStatus;
import com.zerno.type.GDPRRequestType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "gdpr_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GDPRRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Request belongs to a user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GDPRRequestType type; // EXPORT, DELETE

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GDPRRequestStatus status = GDPRRequestStatus.PENDING;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime processedAt;
}
