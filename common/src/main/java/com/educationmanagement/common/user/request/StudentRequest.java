package com.educationmanagement.common.user.request;

import com.educationmanagement.common.user.model.Address;
import com.educationmanagement.common.user.model.EnrolledClass;
import com.educationmanagement.common.user.model.UserDetails;
import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {

    private String studentId;
    private UserDetails userDetails;
    private EnrolledClass currentClass;
    private List<EnrolledClass> previousClasses;
    private Address permanentAddress;
    private Address temporaryAddress;
}
