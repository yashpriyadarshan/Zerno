package com.zerno.entity.system;

import com.zerno.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "analytics_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyticsEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eventType; // e.g., "PAGEVIEW", "SEARCH", "CLICK"

    @Column(nullable = true)
    private String sessionId; // optional (web tracking)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // nullable for anonymous users

    @Lob
    private String metadata; // JSON data (e.g., { "page": "/home", "query": "laptop" })

    @CreationTimestamp
    private LocalDateTime createdAt;
}
