package com.taskora.api.features.tutorial.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTutorialStepRequest {

    @NotNull(message = "Step number is required.")
    private Integer stepNumber;

    @NotBlank(message = "Instruction is required.")
    @Size(max = 5000, message = "Instruction must not exceed 5000 characters.")
    private String instruction;

}