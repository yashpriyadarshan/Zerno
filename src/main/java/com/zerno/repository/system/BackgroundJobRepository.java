package com.zerno.repository.system;

import com.zerno.entity.system.BackgroundJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackgroundJobRepository extends JpaRepository<BackgroundJob, Long> {
}