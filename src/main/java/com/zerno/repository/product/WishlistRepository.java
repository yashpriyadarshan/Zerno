package com.zerno.repository.product;

import com.zerno.entity.product.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    // Find all wishlists for a specific user
    List<Wishlist> findByUserId(Long userId);

    // Optional: find wishlist by user and name
    Wishlist findByUserIdAndName(Long userId, String name);
}
