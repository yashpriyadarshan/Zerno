package com.zerno.repository.inventory;

import com.zerno.entity.inventory.Inventory;
import com.zerno.entity.inventory.Warehouse;
import com.zerno.entity.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Find inventory record for a given product variant in a specific warehouse
    Optional<Inventory> findByVariantAndWarehouse(ProductVariant variant, Warehouse warehouse);

    // Find all inventory records for a product variant across warehouses
    List<Inventory> findByVariant(ProductVariant variant);

    // Find all inventory records inside a warehouse
    List<Inventory> findByWarehouse(Warehouse warehouse);

    // Check if inventory exists for a variant in a warehouse
    boolean existsByVariantAndWarehouse(ProductVariant variant, Warehouse warehouse);
}
