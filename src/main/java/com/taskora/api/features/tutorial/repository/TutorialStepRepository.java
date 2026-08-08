package com.taskora.api.features.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskora.api.features.tutorial.entity.TutorialStep;

public interface TutorialStepRepository
        extends JpaRepository<TutorialStep, Long> {

    List<TutorialStep> findAllByTutorialId(Long tutorialId);
}