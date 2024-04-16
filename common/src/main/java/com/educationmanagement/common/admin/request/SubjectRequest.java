package com.educationmanagement.common.admin.request;

import lombok.Data;

import java.time.Instant;

@Data
public class SubjectRequest {

    private String tenantId;
    private String name;
    private String description;

}
