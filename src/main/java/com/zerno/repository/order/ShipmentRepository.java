package com.zerno.repository.order;

import com.zerno.entity.order.Shipment;
import com.zerno.entity.order.Order;
import com.zerno.type.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    // Find shipments for an order
    List<Shipment> findByOrder(Order order);

    // Find shipments by orderId
    List<Shipment> findByOrderId(Long orderId);

    // Find shipments by status
    List<Shipment> findByStatus(ShipmentStatus status);

    // Find by tracking number (unique carrier reference)
    Shipment findByTrackingNumber(String trackingNumber);

    // Find shipments by carrier
    List<Shipment> findByCarrier(String carrier);
}
