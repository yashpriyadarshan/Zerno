package com.zerno.repository.product;

import com.zerno.entity.product.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

    // Find all items for a specific wishlist
    List<WishlistItem> findByWishlistId(Long wishlistId);

    // Optional: find a specific wishlist item by wishlist and product
    WishlistItem findByWishlistIdAndProduct_Id(Long wishlistId, Long productId);

    // Optional: delete all items for a wishlist
    void deleteByWishlistId(Long wishlistId);
}
