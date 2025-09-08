package com.zerno.repository.order;

import com.zerno.entity.order.Order;
import com.zerno.entity.order.OrderAddress;
import com.zerno.type.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAddress, Long> {

    // Find all addresses for a given order
    List<OrderAddress> findByOrder(Order order);

    // Find address for a given order and type (e.g., SHIPPING, BILLING)
    Optional<OrderAddress> findByOrderAndAddressType(Order order, AddressType addressType);

    // Find all addresses of a given type across all orders (rare, but can be useful for reporting)
    List<OrderAddress> findByAddressType(AddressType addressType);
}
