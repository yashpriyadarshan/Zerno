package com.zerno.repository.system;

import com.zerno.entity.system.GDPRRequest;
import com.zerno.type.GDPRRequestStatus;
import com.zerno.type.GDPRRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GDPRRequestRepository extends JpaRepository<GDPRRequest, Long> {

    // Find all requests by user
    List<GDPRRequest> findByUserId(Long userId);

    // Find requests by status
    List<GDPRRequest> findByStatus(GDPRRequestStatus status);

    // Find requests by type
    List<GDPRRequest> findByType(GDPRRequestType type);

    // Find requests by user and status
    List<GDPRRequest> findByUserIdAndStatus(Long userId, GDPRRequestStatus status);

    // Find requests by status and type
    List<GDPRRequest> findByStatusAndType(GDPRRequestStatus status, GDPRRequestType type);
}
