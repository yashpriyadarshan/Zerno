package com.zerno.repository.user;

import com.zerno.entity.user.Address;
import com.zerno.type.AddressOwnerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // Find all addresses for a given user
    List<Address> findByUserId(Long userId);

    // Find all addresses for a given seller
    List<Address> findBySellerId(Long sellerId);

    // Find all addresses for a given store
    List<Address> findByStoreId(Long storeId);

    // Find all addresses for a given warehouse
    List<Address> findByWarehouseId(Long warehouseId);

    // Find all addresses by owner type
    List<Address> findByOwnerType(AddressOwnerType ownerType);

    // Find default addresses for a specific owner
    List<Address> findByOwnerIdAndIsDefaultTrue(Long ownerId);

    // Find by user and default
    List<Address> findByUserIdAndIsDefaultTrue(Long userId);
}
