package com.educationmanagement.common.user.response;

import com.educationmanagement.common.user.model.Address;
import com.educationmanagement.common.user.model.StudentParent;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class ParentResponse {
    private String _id;
    private String tenantId;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address permanentAddress;
    private Address temporaryAddress;
    private List<StudentParent> students;
    private Instant createdAt;
    private Instant updatedAt;
}