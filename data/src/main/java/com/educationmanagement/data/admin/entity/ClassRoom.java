package com.educationmanagement.data.admin.entity;

import com.educationmanagement.data.admin.helper.ClassTeacher;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "classroom")
public class ClassRoom {

    @Id
    private String _id;
    private String tenantId;
    private String name;
    private String section;
    private List<String> subjects;
    private Boolean isActive;
    private ClassTeacher classTeacher;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;
}
