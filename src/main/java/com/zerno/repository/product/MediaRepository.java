package com.zerno.repository.product;

import com.zerno.entity.product.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    // Fetch all media for a given owner (type + id)
    List<Media> findByOwnerTypeAndOwnerId(String ownerType, Long ownerId);

    // Find by unique s3Key
    Optional<Media> findByS3Key(String s3Key);

    // Check if media exists for a given s3Key
    boolean existsByS3Key(String s3Key);

    // Delete all media for a specific owner
    void deleteByOwnerTypeAndOwnerId(String ownerType, Long ownerId);
}
