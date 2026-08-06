package com.taskora.api.features.tutorial.entity;

import com.taskora.api.common.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tutorial_steps")
public class TutorialStep extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;

    private Integer stepNumber;

    private String instruction;

    private String imageUrl;

}