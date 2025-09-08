package com.zerno.repository.system;

import com.zerno.entity.system.AnalyticsEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsEventRepository extends JpaRepository<AnalyticsEvent, Long> {

    // Find all events by a specific user
    List<AnalyticsEvent> findByUserId(Long userId);

    // Find all events of a specific type
    List<AnalyticsEvent> findByEventType(String eventType);
}
