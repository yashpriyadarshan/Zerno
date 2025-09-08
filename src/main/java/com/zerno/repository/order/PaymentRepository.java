package com.zerno.repository.order;

import com.zerno.entity.order.Payment;
import com.zerno.entity.order.Order;
import com.zerno.type.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payment by providerPaymentId (transaction ID)
    Optional<Payment> findByProviderPaymentId(String providerPaymentId);

    // Find all payments for a given order
    List<Payment> findByOrder(Order order);

    // Find payments by order id
    List<Payment> findByOrderId(Long orderId);

    // Find payments by status
    List<Payment> findByStatus(PaymentStatus status);

    // Check if a payment exists for a transaction ID
    boolean existsByProviderPaymentId(String providerPaymentId);
}
