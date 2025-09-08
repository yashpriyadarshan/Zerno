package com.zerno.repository.order;

import com.zerno.entity.order.Refund;
import com.zerno.entity.order.Payment;
import com.zerno.type.RefundStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {

    // Find all refunds for a payment
    List<Refund> findByPayment(Payment payment);

    // Find refunds by payment id
    List<Refund> findByPaymentId(Long paymentId);

    // Find refunds by status
    List<Refund> findByStatus(RefundStatus status);

    // Find refunds by payment and status
    List<Refund> findByPaymentAndStatus(Payment payment, RefundStatus status);

    // Calculate total refunded amount for a payment (Spring Data derived query won't sum automatically, use @Query if needed)
}
