package com.educationmanagement.data.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Data
@Document(collection = "user")
public class User {
    @Id
    private String _id;
    private String tenantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String role;
    private Boolean isActive;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;

}