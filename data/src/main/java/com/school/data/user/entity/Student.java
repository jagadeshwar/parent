package com.school.data.entity.user;

import com.school.data.EnrolledClass;
import com.school.data.ParentStudent;
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
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private String rollNum;
    private List<ParentStudent> parentStudents;
    private List<EnrolledClass> enrolledClasses;
    private Instant createdAt;
    private Instant updatedAt;
}



