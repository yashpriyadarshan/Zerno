package com.zerno.repository.support;

import com.zerno.entity.support.TicketMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMessageRepository extends JpaRepository<TicketMessage, Long> {

    // Find all messages for a specific ticket
    List<TicketMessage> findByTicketId(Long ticketId);

    // Optional: Find all messages by a specific user
    List<TicketMessage> findByUserId(Long userId);
}
