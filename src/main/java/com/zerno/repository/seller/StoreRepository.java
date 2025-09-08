package com.zerno.repository.seller;

import com.zerno.entity.seller.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    // Find all stores belonging to a particular seller
    List<Store> findBySellerId(Long sellerId);

    // Find a store by its unique slug
    Optional<Store> findBySlug(String slug);
}
