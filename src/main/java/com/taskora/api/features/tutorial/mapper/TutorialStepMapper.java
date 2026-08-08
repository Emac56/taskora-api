package com.taskora.api.features.tutorial.mapper;

import org.springframework.stereotype.Component;

import com.taskora.api.features.tutorial.dto.request.CreateTutorialStepRequest;
import com.taskora.api.features.tutorial.dto.response.TutorialStepResponse;
import com.taskora.api.features.tutorial.entity.TutorialStep;

@Component
public class TutorialStepMapper {

    public TutorialStep toEntity(CreateTutorialStepRequest request) {
        TutorialStep tutorialStep = new TutorialStep();

        tutorialStep.setStepNumber(request.getStepNumber());
        tutorialStep.setInstruction(request.getInstruction());

        return tutorialStep;
    }

    public TutorialStepResponse toResponse(TutorialStep tutorialStep) {
        TutorialStepResponse response = new TutorialStepResponse();

        response.setId(tutorialStep.getId());
        response.setStepNumber(tutorialStep.getStepNumber());
        response.setInstruction(tutorialStep.getInstruction());
        response.setImageUrl(tutorialStep.getImageUrl());

        return response;
    }
}