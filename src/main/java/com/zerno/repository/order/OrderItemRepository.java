package com.zerno.repository.order;

import com.zerno.entity.order.OrderItem;
import com.zerno.entity.order.Order;
import com.zerno.entity.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Find all items for a given order
    List<OrderItem> findByOrder(Order order);

    // Find all items for a given product variant
    List<OrderItem> findByVariant(ProductVariant variant);

    // Find items by order id (avoids fetching full Order entity)
    List<OrderItem> findByOrderId(Long orderId);

    // Optional: delete all items of an order
    void deleteByOrder(Order order);
}
