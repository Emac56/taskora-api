package com.taskora.api.features.tutorial.repository;

import com.taskora.api.features.tutorial.entity.AuditTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditTestRepository extends JpaRepository<AuditTest, Long> {
}