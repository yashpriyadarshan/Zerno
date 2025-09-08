package com.zerno.repository.seller;

import com.zerno.entity.seller.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}