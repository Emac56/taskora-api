package com.taskora.api.features.tutorial.entity;

import com.taskora.api.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuditTest extends BaseEntity {

    private String name;

}