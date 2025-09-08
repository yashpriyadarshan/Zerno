package com.zerno.repository.seller;

import com.zerno.entity.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    // Find seller by owner user ID
    Optional<Seller> findByOwnerId(Long userId);

    // Find seller by GST number
    Optional<Seller> findByGstNumber(String gstNumber);
}
