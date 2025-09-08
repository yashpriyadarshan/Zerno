package com.zerno.repository.system;

import com.zerno.entity.system.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // Find all audit logs for a specific table
    List<AuditLog> findByTableName(String tableName);

    // Find all audit logs for a specific record
    List<AuditLog> findByTableNameAndRecordId(String tableName, Long recordId);

    // Find all audit logs done by a specific user
    List<AuditLog> findByUserId(Long userId);
}
