package com.educationmanagement.common.user.request;

import com.educationmanagement.common.user.model.Address;
import com.educationmanagement.common.user.model.UserDetails;
import lombok.Data;

@Data
public class ParentRequest {
    private String parentId;
    private UserDetails userDetails;
    private Address permanentAddress;
    private Address temporaryAddress;
}
