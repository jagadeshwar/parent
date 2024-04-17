package com.educationmanagement.common.user.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Data
public class UserDetails {

    private String tenantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
    private String role;
    private Boolean isActive;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;

}