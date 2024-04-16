package com.educationmanagement.data.user.entity;

import com.educationmanagement.common.user.model.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "teacher")
public class Teacher {
    
    @Id
    private String _id;
    private String tenantId;
    private String userId;
    private String qualification;
    private List<String> teachingSubjects;
    private String primaryTeachingSubject;
    private String classTeacherFor;
    private Address permanentAddress;
    private Address temporaryAddress;

    private Instant createdAt;
    private Instant updatedAt;

}