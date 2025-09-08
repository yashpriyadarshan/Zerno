package com.zerno.repository.inventory;

import com.zerno.entity.inventory.StockMovement;
import com.zerno.entity.inventory.Warehouse;
import com.zerno.entity.product.ProductVariant;
import com.zerno.type.MovementReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    // Find movements for a specific variant
    List<StockMovement> findByVariant(ProductVariant variant);

    // Find movements for a specific warehouse
    List<StockMovement> findByWarehouse(Warehouse warehouse);

    // Find movements by reason (ORDER_PLACED, RETURN, etc.)
    List<StockMovement> findByReason(MovementReason reason);

    // Find movements by referenceId (Order_ID, Return_ID, etc.)
    List<StockMovement> findByReferenceId(String referenceId);

    // Find movements within a date range
    List<StockMovement> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
