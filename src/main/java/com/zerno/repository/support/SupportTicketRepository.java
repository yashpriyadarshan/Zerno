package com.zerno.repository.support;

import com.zerno.entity.support.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

    // Find all tickets for a specific user
    List<SupportTicket> findByUserId(Long userId);

    // Find all tickets with a specific status
    List<SupportTicket> findByStatus(String status);
}
