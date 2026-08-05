package com.taskora.api.common.config;

import com.taskora.api.features.tutorial.entity.AuditTest;
import com.taskora.api.features.tutorial.repository.AuditTestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditTestRunner {

    @Bean
    CommandLineRunner testAudit(AuditTestRepository repository) {
        return args -> {

            AuditTest test = new AuditTest();
            test.setName("JPA Auditing Test");

            repository.save(test);

            System.out.println("=== AUDIT TEST SAVED ===");
        };
    }
}