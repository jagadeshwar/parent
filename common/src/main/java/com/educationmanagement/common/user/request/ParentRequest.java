package com.educationmanagement.common.user.request;

import com.educationmanagement.common.user.model.Address;
import lombok.Data;

@Data
public class ParentRequest {
    private String tenantId;
    private String parentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address permanentAddress;
    private Address temporaryAddress;
}
