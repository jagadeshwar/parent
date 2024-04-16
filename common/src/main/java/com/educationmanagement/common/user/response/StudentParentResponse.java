package com.educationmanagement.common.user.response;

import lombok.Data;

import java.time.Instant;

@Data
public class StudentParentResponse {
    private String studentId;
    private String parentId;
    private String status;
    private Instant createdDateTime;
}
