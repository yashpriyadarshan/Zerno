package com.zerno.entity.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "media",
        indexes = {
                @Index(name = "idx_media_owner", columnList = "ownerType, ownerId")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Polymorphic owner (Product/User/Seller/etc.)
    @Column(nullable = false, length = 50)
    private String ownerType; // e.g., "PRODUCT", "USER", "SELLER"

    @Column(nullable = false)
    private Long ownerId; // references the entity's id

    @Column(nullable = false, unique = true, length = 255)
    private String s3Key; // S3/GCS/Azure key or relative path

    @Column(nullable = false, length = 50)
    private String mimeType; // e.g., "image/jpeg", "video/mp4"

    @Column(nullable = false)
    private Long size; // file size in bytes

    @CreationTimestamp
    private LocalDateTime createdAt;
}
