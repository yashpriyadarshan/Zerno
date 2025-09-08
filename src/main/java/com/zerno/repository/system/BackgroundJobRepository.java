package com.zerno.repository.system;

import com.zerno.entity.system.BackgroundJob;
import com.zerno.type.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackgroundJobRepository extends JpaRepository<BackgroundJob, Long> {

    // Find all jobs by their status
    List<BackgroundJob> findByStatus(JobStatus status);

    // Find jobs of a specific type and status
    List<BackgroundJob> findByTypeAndStatus(String type, JobStatus status);

    // Optionally, find jobs that haven't exceeded a certain number of attempts
    List<BackgroundJob> findByStatusAndAttemptsLessThan(JobStatus status, Integer maxAttempts);
}
