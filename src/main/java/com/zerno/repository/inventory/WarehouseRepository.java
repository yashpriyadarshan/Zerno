package com.zerno.repository.inventory;

import com.zerno.entity.inventory.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    // Find warehouse by its unique name
    Optional<Warehouse> findByName(String name);

    // Get all active warehouses
    List<Warehouse> findByActiveTrue();

    // Get all inactive warehouses
    List<Warehouse> findByActiveFalse();

    // Check if a warehouse exists by phone number
    boolean existsByPhone(String phone);
}
