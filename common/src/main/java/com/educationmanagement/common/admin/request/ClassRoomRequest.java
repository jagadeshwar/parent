package com.educationmanagement.common.admin.request;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ClassRoomRequest {

    private String tenantId;
    private String name;
    private String section;
    private List<String> subjects;
    private Boolean isActive;
    private ClassTeacher classTeacher;
    private Instant createdAt;
    private Instant updatedAt;
}
