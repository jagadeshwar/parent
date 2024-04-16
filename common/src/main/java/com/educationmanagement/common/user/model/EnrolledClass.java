package com.educationmanagement.common.user.model;

import lombok.Data;

import java.time.Instant;

@Data
public class EnrolledClass {
    private String classId;
    private Integer classNumber;
    private String className;
    private Instant enrollmentDate;
}