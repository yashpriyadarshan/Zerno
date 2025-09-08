package com.zerno.repository.order;

import com.zerno.entity.order.Order;
import com.zerno.entity.user.User;
import com.zerno.entity.seller.Seller;
import com.zerno.type.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Find order by unique order number
    Optional<Order> findByOrderNumber(String orderNumber);

    // Find all orders by user
    List<Order> findByUser(User user);

    // Find all orders by seller
    List<Order> findBySeller(Seller seller);

    // Find all orders by status
    List<Order> findByStatus(OrderStatus status);

    // Check if an order exists by order number
    boolean existsByOrderNumber(String orderNumber);
}
