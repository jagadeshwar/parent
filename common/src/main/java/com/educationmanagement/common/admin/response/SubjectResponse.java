package com.educationmanagement.common.admin.response;

import lombok.Data;

import java.time.Instant;

@Data
public class SubjectResponse {

    private String tenantId;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
}
