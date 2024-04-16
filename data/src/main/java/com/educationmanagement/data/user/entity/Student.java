package com.educationmanagement.data.user.entity;

import com.educationmanagement.common.user.model.EnrolledClass;
import com.educationmanagement.common.user.model.ParentStudent;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "student")
public class Student {
    @Id
    private String _id;
    private String tenantId;
    private String userId;
    private Instant dateOfBirth;
    private String rollNum;
    private List<ParentStudent> parentStudents;
    private EnrolledClass currentClass;
    private List<EnrolledClass> previousClasses;

    private Instant createdAt;
    private Instant updatedAt;
}



