package com.zerno.repository.system;

import com.zerno.entity.system.GDPRRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GDPRRequestRepository extends JpaRepository<GDPRRequest, Long> {
}