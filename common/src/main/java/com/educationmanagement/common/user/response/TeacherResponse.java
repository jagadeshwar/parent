package com.educationmanagement.common.user.response;

import com.educationmanagement.common.user.model.Address;
import lombok.Data;

import java.util.List;

@Data
public class TeacherResponse {
    private String tenantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String qualification;
    private List<String> subjects;
    private String classTeacherFor;
    private Address permanentAddress;
    private Address temporaryAddress;
}