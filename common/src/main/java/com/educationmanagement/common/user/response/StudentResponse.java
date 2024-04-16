package com.educationmanagement.common.user.response;

import com.educationmanagement.common.user.model.EnrolledClass;
import com.educationmanagement.common.user.model.ParentStudent;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class StudentResponse {
    private String _id;
    private String tenantId;
    private String userId;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private String rollNum;
    private List<ParentStudent> parentStudents;
    private EnrolledClass currentClass;
    private List<EnrolledClass> previousClasses;
    private Instant createdAt;
    private Instant updatedAt;
}