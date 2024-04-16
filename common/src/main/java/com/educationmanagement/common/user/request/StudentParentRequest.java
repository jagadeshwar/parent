package com.educationmanagement.common.user.request;

import lombok.Data;

@Data
public class StudentParentRequest {

    private StudentRequest student;
    private ParentRequest parent;

}
