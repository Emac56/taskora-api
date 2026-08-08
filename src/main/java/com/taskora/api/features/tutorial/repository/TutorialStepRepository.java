package com.taskora.api.features.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskora.api.features.tutorial.entity.TutorialStep;

public interface TutorialStepRepository extends JpaRepository<TutorialStep, Long> {
}