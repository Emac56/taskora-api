package com.taskora.api.features.tutorial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.taskora.api.features.tutorial.entity.Tutorial;
import com.taskora.api.features.tutorial.entity.TutorialStep;
import com.taskora.api.features.tutorial.enums.TutorialStatus;

@DataJpaTest
class TutorialStepRepositoryTest {

    @Autowired
    private TutorialStepRepository tutorialStepRepository;

    @Test
    void shouldSaveAndFindTutorialStep() {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("Java Basics");
        tutorial.setDescription("Learn Java fundamentals.");
        tutorial.setStatus(TutorialStatus.DRAFT);

        TutorialStep step = new TutorialStep();
        step.setTutorial(tutorial);
        step.setStepNumber(1);
        step.setInstruction("Open the Java project.");

        TutorialStep savedStep = tutorialStepRepository.save(step);

        Optional<TutorialStep> result =
                tutorialStepRepository.findById(savedStep.getId());

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getStepNumber());
        assertEquals(
                "Open the Java project.",
                result.get().getInstruction()
        );
    }

    @Test
    void shouldFindAllTutorialSteps() {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("Java Basics");
        tutorial.setDescription("Learn Java fundamentals.");
        tutorial.setStatus(TutorialStatus.DRAFT);

        TutorialStep firstStep = new TutorialStep();
        firstStep.setTutorial(tutorial);
        firstStep.setStepNumber(1);
        firstStep.setInstruction("Open the project.");

        TutorialStep secondStep = new TutorialStep();
        secondStep.setTutorial(tutorial);
        secondStep.setStepNumber(2);
        secondStep.setInstruction("Create a Java class.");

        tutorialStepRepository.save(firstStep);
        tutorialStepRepository.save(secondStep);

        assertEquals(2, tutorialStepRepository.findAll().size());
    }

    @Test
    void shouldDeleteTutorialStep() {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle("Temporary Tutorial");
        tutorial.setDescription("Temporary tutorial.");
        tutorial.setStatus(TutorialStatus.DRAFT);

        TutorialStep step = new TutorialStep();
        step.setTutorial(tutorial);
        step.setStepNumber(1);
        step.setInstruction("Temporary step.");

        TutorialStep savedStep = tutorialStepRepository.save(step);

        tutorialStepRepository.deleteById(savedStep.getId());

        assertFalse(
                tutorialStepRepository.existsById(savedStep.getId())
        );
    }
}