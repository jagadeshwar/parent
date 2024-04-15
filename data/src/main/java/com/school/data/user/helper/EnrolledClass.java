package com.school.data;

import lombok.Data;

import java.time.Instant;

@Data
public class EnrolledClass {
    private String classId;
    private String className;
    private String session;
    private Instant enrollmentDate;
}