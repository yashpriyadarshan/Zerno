package com.zerno.entity.system;

import com.zerno.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tableName; // e.g., "orders", "users"

    @Column(nullable = false)
    private Long recordId; // the affected record's ID

    @Lob
    private String oldData; // JSON snapshot of previous state

    @Lob
    private String newData; // JSON snapshot of new state

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // nullable if action performed by system

    @CreationTimestamp
    private LocalDateTime createdAt;
}
