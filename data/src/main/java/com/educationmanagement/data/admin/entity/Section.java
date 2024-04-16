package com.educationmanagement.data.admin.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "section")
public class Section {

    @Id
    private String _id;
    private String tenantId;
    private String name;
    private String description;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;
}
