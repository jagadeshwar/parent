package com.educationmanagement.common.user.request;

import com.educationmanagement.common.user.model.Address;
import com.educationmanagement.common.user.model.EnrolledClass;
import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private String tenantId;
    private String studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String phoneNumber;
    private EnrolledClass currentClass;
    private List<EnrolledClass> previousClasses;
    private Address permanentAddress;
    private Address temporaryAddress;
}
