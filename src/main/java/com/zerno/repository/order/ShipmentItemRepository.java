package com.zerno.repository.order;

import com.zerno.entity.order.ShipmentItem;
import com.zerno.entity.order.Shipment;
import com.zerno.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentItemRepository extends JpaRepository<ShipmentItem, Long> {

    // Find all items in a shipment
    List<ShipmentItem> findByShipment(Shipment shipment);

    // Find all items in a shipment by ID
    List<ShipmentItem> findByShipmentId(Long shipmentId);

    // Find by order item
    List<ShipmentItem> findByOrderItem(OrderItem orderItem);

    // Find by order item ID
    List<ShipmentItem> findByOrderItemId(Long orderItemId);

    // Check if an order item is already linked to a shipment
    boolean existsByShipmentIdAndOrderItemId(Long shipmentId, Long orderItemId);
}
